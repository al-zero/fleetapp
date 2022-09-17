package alphasabawu.co.zw.fleetapp.controllers;

import alphasabawu.co.zw.fleetapp.models.VehicleMake;
import alphasabawu.co.zw.fleetapp.models.VehicleModel;
import alphasabawu.co.zw.fleetapp.services.VehicleMakeService;
import alphasabawu.co.zw.fleetapp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;


    @GetMapping("/vehicleModels")
    public String getVehicleModel(Model model){

        List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();

        model.addAttribute("vehicleModels", vehicleModelList);

        return "vehicleModel";
    }


    @PostMapping("/vehicleModels/addNew")
    public String addVehicleModel(VehicleModel vehicleModel){
        vehicleModelService.saveVehicleModel(vehicleModel);
        return "redirect:/vehicleMake";
    }

    @RequestMapping("/vehicleModels/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(int id){
        return vehicleModelService.getVehicleModelByID(id);
    }

    @RequestMapping(value = "/vehicleModels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleMakes(VehicleModel vehicleModel){
        vehicleModelService.saveVehicleModel(vehicleModel);
        return "redirect:/vehicleMake";
    }
    @RequestMapping(value = "/vehicleModels/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleMakes(Integer id){
        vehicleModelService.removeVehicleModel(id);
        return "redirect:/vehicleMake";
    }
}
