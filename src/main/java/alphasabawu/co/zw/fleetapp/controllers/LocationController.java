package alphasabawu.co.zw.fleetapp.controllers;

import alphasabawu.co.zw.fleetapp.models.Country;
import alphasabawu.co.zw.fleetapp.models.Location;
import alphasabawu.co.zw.fleetapp.models.State;
import alphasabawu.co.zw.fleetapp.services.CountryService;
import alphasabawu.co.zw.fleetapp.services.LocationService;
import alphasabawu.co.zw.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {


    @Autowired
    private StateService stateService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private CountryService countryService;



    @GetMapping("/locations")
    public String getLocation(Model model){
        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();
        List<Location> locationList = locationService.getLocations();

        model.addAttribute("states", stateList);
        model.addAttribute("countries", countryList);
        model.addAttribute("locations", locationList);

        return "location";
    }


    @PostMapping("/locations/addNew")
    public String addNewLocations(Location location){
        locationService.saveLocation(location);
        return "redirect:/locations";
    }

    @RequestMapping("/locations/findById")
    @ResponseBody
    public Optional<Location> findById(int id){
        return locationService.getLocationByID(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateLocation(Location location){
        locationService.saveLocation(location);
        return "redirect:/locations";
    }
    @RequestMapping(value = "/locations/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteLocation(Integer id){
        locationService.removeLocation(id);
        return "redirect:/locations";
    }

}
