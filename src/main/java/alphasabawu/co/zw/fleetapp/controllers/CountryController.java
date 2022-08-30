package alphasabawu.co.zw.fleetapp.controllers;

import alphasabawu.co.zw.fleetapp.models.Country;
import alphasabawu.co.zw.fleetapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getCountries(Model model){

        List <Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        return "country";
    }

    @PostMapping("/countries/addNew")
    public String addNewCountry(Country country){
        countryService.saveCountry(country);
        return "redirect:/countries";
    }

    @RequestMapping("/countries/findById")
    @ResponseBody
    public Optional<Country> findById(int id){
        return countryService.getCountryByID(id);
    }


    @RequestMapping(value = "/countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateCountry(Country country){
        countryService.saveCountry(country);
        return "redirect:/countries";
    }
}
