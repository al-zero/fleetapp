package alphasabawu.co.zw.fleetapp.controllers;
import alphasabawu.co.zw.fleetapp.models.Country;
import alphasabawu.co.zw.fleetapp.models.State;
import alphasabawu.co.zw.fleetapp.services.CountryService;
import alphasabawu.co.zw.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {
    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/states")
    public String getState(Model model){
        List <State> stateLists = stateService.getStates();
        model.addAttribute("states", stateLists);


        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        return "state";
    }

    @PostMapping("/states/addNew")
    public String addState(State state){
        stateService.saveState(state);
        return "redirect:/states";
    }

    @RequestMapping("/states/findById")
    @ResponseBody
    public Optional<State> findById(int id){
        return stateService.getStateByID(id);
    }


    @RequestMapping(value = "/states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateState(State state){
        stateService.saveState(state);
        return "redirect:/states";
    }
    @RequestMapping(value = "/states/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteState(Integer id){
        stateService.removeState(id);
        return "redirect:/states";
    }

}
