package alphasabawu.co.zw.fleetapp.repositories;

import alphasabawu.co.zw.fleetapp.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}