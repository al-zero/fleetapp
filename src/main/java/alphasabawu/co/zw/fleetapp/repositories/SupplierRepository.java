package alphasabawu.co.zw.fleetapp.repositories;

import alphasabawu.co.zw.fleetapp.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}