package alphasabawu.co.zw.fleetapp.controllers;

import alphasabawu.co.zw.fleetapp.models.VehicleModel;
import alphasabawu.co.zw.fleetapp.models.VehicleType;
import alphasabawu.co.zw.fleetapp.services.VehicleModelService;
import alphasabawu.co.zw.fleetapp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {


    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicleTypes")
    public String getVehicleType(Model model){

        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleType();
        model.addAttribute("vehicleTypes", vehicleTypeList );
        return "vehicleType";
    }



    @PostMapping("/vehicleTypes/addNew")
    public String addVehicleType(VehicleType vehicleType){
        vehicleTypeService.saveVehicleType(vehicleType);
        return "redirect:/vehicleType";
    }

    @RequestMapping("/vehicleTypes/findById")
    @ResponseBody
    public Optional<VehicleType> findById(int id){
        return vehicleTypeService.getVehicleTypeByID(id);
    }

    @RequestMapping(value = "/vehicleTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleType(VehicleType vehicleType){
        vehicleTypeService.saveVehicleType(vehicleType);
        return "redirect:/vehicleType";
    }
    @RequestMapping(value = "/vehicleTypes/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleMakes(Integer id){
        vehicleTypeService.removeVehicleType(id);
        return "redirect:/vehicleType";
    }
}
