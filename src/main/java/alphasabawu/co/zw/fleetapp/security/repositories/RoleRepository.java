package alphasabawu.co.zw.fleetapp.security.repositories;

import alphasabawu.co.zw.fleetapp.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {

    @Query(
            value = "SELECT * FROM role where id NOT IN (select role_id FROM user_role where user_id = ?)",
            nativeQuery=true
    )
    Set<Role> getUserNotRoles(Integer userId);

}
