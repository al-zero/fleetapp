package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.Location;
import alphasabawu.co.zw.fleetapp.models.VehicleMake;
import alphasabawu.co.zw.fleetapp.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {
    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    // Return a list countries
    public List<VehicleMake> getvehicleMake(){
        return vehicleMakeRepository.findAll();
    }


    // Save new country
    public  void saveVehicleMake(VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
        // return ;
    }

    // Get country by ID
    public Optional<VehicleMake> getVehicleMakeByID(int locationId){
        return vehicleMakeRepository.findById(locationId);
    }


    public void removeVehicleMake(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }
}
