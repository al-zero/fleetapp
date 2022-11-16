package alphasabawu.co.zw.fleetapp.security.services;

import alphasabawu.co.zw.fleetapp.models.User;
import alphasabawu.co.zw.fleetapp.repositories.UserRepository;
import alphasabawu.co.zw.fleetapp.security.models.Role;
import alphasabawu.co.zw.fleetapp.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    // Get all Roles
    public List<Role> findAllRoles(){
        return roleRepository.findAll();
    }

    // Get Role by ID
    public Optional <Role> findById(int id){
        return roleRepository.findById(id);
    }

    // Delete Role
    public void delete(int id){
        roleRepository.deleteById(id);
    }

    // Update Role
    public void save(Role role){
        roleRepository.save(role);
    }

    public void assignUserRole(Integer userid, Integer roleId){
        User user = userRepository.findById(userid).orElse(null);
        Role role1 = roleRepository.findById(roleId).orElse(null);

        Set<Role> userRoles = user.getRoles();
        userRoles.add(role1);
        user.setRoles(userRoles);

        userRepository.save(user);
    }
    public void unassignRole(Integer userid, Integer roleid){
        User user = userRepository.findById(userid).orElse(null);
        Set<Role> userRoles = user.getRoles();

        userRoles.removeIf(x -> x.getId() == roleid);
        userRepository.save(user);
    }

    public Set<Role>getUserRoles(User user){
        return  user.getRoles();
    }

    public Set<Role> getUserNotRoles(User user){
        return roleRepository.getUserNotRoles(user.getId());
    }
}
