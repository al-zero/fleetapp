package alphasabawu.co.zw.fleetapp.controllers;

import alphasabawu.co.zw.fleetapp.models.Supplier;
import alphasabawu.co.zw.fleetapp.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    @GetMapping("/suppliers")
    public String getSupplier(){
        return "suppliers";
    }



    @PostMapping("/Suppliers/addNew")
    public String addSupplier(Supplier Supplier){
        supplierService.saveSupplier(Supplier);
        return "redirect:/Suppliers";
    }

    @RequestMapping("/Suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(int id){
        return supplierService.getSupplierByID(id);
    }


    @RequestMapping(value = "/Suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateSupplier(Supplier Supplier){
        supplierService.saveSupplier(Supplier);
        return "redirect:/Suppliers";
    }
    @RequestMapping(value = "/Suppliers/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteSupplier(Integer id){
        supplierService.removeSupplier(id);
        return "redirect:/Suppliers";
    }
}
