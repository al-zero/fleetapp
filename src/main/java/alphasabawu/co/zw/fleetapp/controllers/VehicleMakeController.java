package alphasabawu.co.zw.fleetapp.controllers;

import alphasabawu.co.zw.fleetapp.models.Country;
import alphasabawu.co.zw.fleetapp.models.Location;
import alphasabawu.co.zw.fleetapp.models.State;
import alphasabawu.co.zw.fleetapp.models.VehicleMake;
import alphasabawu.co.zw.fleetapp.services.CountryService;
import alphasabawu.co.zw.fleetapp.services.StateService;
import alphasabawu.co.zw.fleetapp.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;


    @GetMapping("/vehicleMakes")
    public String getVehicleMake(Model model){

        List<VehicleMake> vehicleMakeList = vehicleMakeService.getvehicleMake();
        List<Country> countryList = countryService.getCountries();
        List<State> stateList = stateService.getStates();

        model.addAttribute("vehicleMakes", vehicleMakeList);
        model.addAttribute("countries", countryList);
        model.addAttribute("states", stateList);

        return "vehicleMake";
    }

    @PostMapping("/vehicleMakes/addNew")
    public String addNewVehicleMake(VehicleMake vehicleMake){
        vehicleMakeService.saveVehicleMake(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping("/vehicleMakes/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(int id){
        return vehicleMakeService.getVehicleMakeByID(id);
    }

    @RequestMapping(value = "/vehicleMakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleMake(VehicleMake vehicleMake){
        vehicleMakeService.saveVehicleMake(vehicleMake);
        return "redirect:/vehicleMake";
    }
    @RequestMapping(value = "/vehicleMakes/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleMake(Integer id){
        vehicleMakeService.removeVehicleMake(id);
        return "redirect:/vehicleMake";
    }
}
