package alphasabawu.co.zw.fleetapp.security.controllers;


import alphasabawu.co.zw.fleetapp.security.models.Role;
import alphasabawu.co.zw.fleetapp.security.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/Roles")
    public String getRole(Model model){

        List<Role> RoleList = roleRepository.findAll();
        model.addAttribute("Roles", RoleList );
        return "Role";
    }



    @PostMapping("/Roles/addNew")
    public String addRole(Role Role){
        roleRepository.save(Role);
        return "redirect:/Roles";
    }

    @RequestMapping("/Roles/findById")
    @ResponseBody
    public Optional<Role> findById(int id){
        return roleRepository.findById(id);
    }

    @RequestMapping(value = "/Roles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateRole(Role Role){
        roleRepository.save(Role);
        return "redirect:/Roles";
    }
    @RequestMapping(value = "/Roles/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleMakes(Integer id){
        roleRepository.deleteById(id);
        return "redirect:/Roles";
    }

}
