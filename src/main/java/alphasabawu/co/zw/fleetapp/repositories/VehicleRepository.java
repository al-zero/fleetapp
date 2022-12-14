package alphasabawu.co.zw.fleetapp.repositories;

import alphasabawu.co.zw.fleetapp.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}