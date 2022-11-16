package alphasabawu.co.zw.fleetapp.controllers;

import alphasabawu.co.zw.fleetapp.models.Country;
import alphasabawu.co.zw.fleetapp.models.State;
import alphasabawu.co.zw.fleetapp.models.Supplier;
import alphasabawu.co.zw.fleetapp.services.CountryService;
import alphasabawu.co.zw.fleetapp.services.StateService;
import alphasabawu.co.zw.fleetapp.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/suppliers")
    public String getSupplier(Model model){

        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();
        List<Supplier> supplierList = supplierService.getSuppliers();

        model.addAttribute("countries", countryList);
        model.addAttribute("states", stateList);
        model.addAttribute("suppliers", supplierList);

        return "suppliers";
    }



    @PostMapping("/suppliers/addNew")
    public String addSupplier(Supplier Supplier){
        supplierService.saveSupplier(Supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping("/suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(int id){
        return supplierService.getSupplierByID(id);
    }


    @RequestMapping(value = "/suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateSupplier(Supplier Supplier){
        supplierService.saveSupplier(Supplier);
        return "redirect:suppliers";
    }
    @RequestMapping(value = "/suppliers/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteSupplier(Integer id){
        supplierService.removeSupplier(id);
        return "redirect:/suppliers";
    }
}
