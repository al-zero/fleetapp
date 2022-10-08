package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.Invoice;
import alphasabawu.co.zw.fleetapp.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    
    @Autowired
    private InvoiceRepository invoiceRepository;
    // Get Invoices
    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }
    // Add Invoices
    public void saveInvoice(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public Optional<Invoice> getInvoiceByID(int id) {
        return invoiceRepository.findById(id);
    }

    public void removeInvoice(Integer id) {
        invoiceRepository.deleteById(id);
    }
    
    
}
