package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.InvoiceStatus;
import alphasabawu.co.zw.fleetapp.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    // Return a list countries
    public List<InvoiceStatus> getInvoiceStatuss(){
        return invoiceStatusRepository.findAll();
    }


    // Save new country
    public  void saveInvoiceStatus(InvoiceStatus invoiceStatus){
        invoiceStatusRepository.save(invoiceStatus);
        // return ;
    }

    // Get country by ID
    public Optional<InvoiceStatus> getInvoiceStatusByID(int InvoiceStatusId){
        return invoiceStatusRepository.findById(InvoiceStatusId);
    }


    public void removeInvoiceStatus(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }
}
