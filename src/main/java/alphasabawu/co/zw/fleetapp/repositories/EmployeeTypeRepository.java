package alphasabawu.co.zw.fleetapp.repositories;

import alphasabawu.co.zw.fleetapp.models.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {
}