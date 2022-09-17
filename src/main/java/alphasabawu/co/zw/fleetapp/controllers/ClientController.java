package alphasabawu.co.zw.fleetapp.controllers;
import alphasabawu.co.zw.fleetapp.models.Client;
import alphasabawu.co.zw.fleetapp.models.Country;
import alphasabawu.co.zw.fleetapp.models.State;
import alphasabawu.co.zw.fleetapp.services.ClientService;
import alphasabawu.co.zw.fleetapp.services.CountryService;
import alphasabawu.co.zw.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {


    @Autowired
    private ClientService clientService;

    @Autowired
    StateService stateService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/clients")
    public String getClient(Model model){
        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();
        List<Client> clientList = clientService.getClients();


        model.addAttribute("states", stateList);
        model.addAttribute("countries", countryList);
        model.addAttribute("clients", stateList);


        return "client";
    }
    

    @PostMapping("/Clients/addNew")
    public String addClient(Client client){
        clientService.saveClient(client);
        return "redirect:/Clients";
    }

    @RequestMapping("/Clients/findById")
    @ResponseBody
    public Optional<Client> findById(int id){
        return clientService.getClientByID(id);
    }


    @RequestMapping(value = "/Clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateClient(Client client){
        clientService.saveClient(client);
        return "redirect:/Clients";
    }
    @RequestMapping(value = "/Clients/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteClient(Integer id){
        clientService.removeClient(id);
        return "redirect:/Clients";
    }

}
