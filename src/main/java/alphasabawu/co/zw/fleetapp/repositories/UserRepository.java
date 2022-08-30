package alphasabawu.co.zw.fleetapp.repositories;

import alphasabawu.co.zw.fleetapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}