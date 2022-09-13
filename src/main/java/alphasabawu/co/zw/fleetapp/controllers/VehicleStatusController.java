package alphasabawu.co.zw.fleetapp.controllers;


import alphasabawu.co.zw.fleetapp.models.VehicleStatus;
import alphasabawu.co.zw.fleetapp.models.VehicleType;
import alphasabawu.co.zw.fleetapp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;


    @GetMapping("/vehicleStatuses")
    public String getVehicleStatus(Model model){

        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();
        model.addAttribute("vehicleStatus", vehicleStatusList );
        return "vehicleStatus";
    }

    @PostMapping("/vehicleStatuses/addNew")
    public String addVehicleType(VehicleStatus vehicleStatus){
        vehicleStatusService.saveVehicleStatus(vehicleStatus);
        return "redirect:/vehicleStatus";
    }

    @RequestMapping("/vehicleStatuses/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(int id){
        return vehicleStatusService.getVehicleStatusByID(id);
    }

    @RequestMapping(value = "/vehicleStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleStatus(VehicleStatus vehicleStatus){
        vehicleStatusService.saveVehicleStatus(vehicleStatus);
        return "redirect:/vehicleStatus";
    }
    @RequestMapping(value = "/vehicleStatuses/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleStatus(Integer id){
        vehicleStatusService.removeVehicleStatus(id);
        return "redirect:/vehicleStatus";
    }

}
