package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.Supplier;
import alphasabawu.co.zw.fleetapp.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {


    @Autowired
    private SupplierRepository SupplierRepository;
    // Get Suppliers
    public List<Supplier> getSuppliers(){
        return SupplierRepository.findAll();
    }
    // Add Suppliers
    public void saveSupplier(Supplier Supplier){
        SupplierRepository.save(Supplier);
    }

    public Optional<Supplier> getSupplierByID(int id) {
        return SupplierRepository.findById(id);
    }

    public void removeSupplier(Integer id) {
        SupplierRepository.deleteById(id);
    }
}
