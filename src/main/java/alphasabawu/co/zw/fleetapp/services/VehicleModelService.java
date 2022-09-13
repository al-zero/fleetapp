package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.VehicleModel;
import alphasabawu.co.zw.fleetapp.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    // Return a list countries
    public List<VehicleModel> getVehicleModels(){
        return vehicleModelRepository.findAll();
    }


    // Save new country
    public  void saveVehicleModel(VehicleModel VehicleModel){
        vehicleModelRepository.save(VehicleModel);
        // return ;
    }

    // Get country by ID
    public Optional<VehicleModel> getVehicleModelByID(int VehicleModelId){
        return vehicleModelRepository.findById(VehicleModelId);
    }


    public void removeVehicleModel(Integer id) {
        vehicleModelRepository.deleteById(id);
    }
}
