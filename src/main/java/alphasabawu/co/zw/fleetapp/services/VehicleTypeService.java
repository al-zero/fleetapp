package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.VehicleType;
import alphasabawu.co.zw.fleetapp.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    // Return a list countries
    public List<VehicleType> getVehicleType(){
        return vehicleTypeRepository.findAll();
    }


    // Save new country
    public  void saveVehicleType(VehicleType vehicleType){
        vehicleTypeRepository.save(vehicleType);
        // return ;
    }

    // Get country by ID
    public Optional<VehicleType> getVehicleTypeByID(int vehicleTypeId){
        return vehicleTypeRepository.findById(vehicleTypeId);
    }


    public void removeVehicleType(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }
}
