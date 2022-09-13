package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.VehicleStatus;
import alphasabawu.co.zw.fleetapp.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    // Return a list countries
    public List<VehicleStatus> getVehicleStatus(){
        return vehicleStatusRepository.findAll();
    }


    // Save new country
    public  void saveVehicleStatus(VehicleStatus VehicleStatus){
        vehicleStatusRepository.save(VehicleStatus);
        // return ;
    }

    // Get country by ID
    public Optional<VehicleStatus> getVehicleStatusByID(int VehicleStatusId){
        return vehicleStatusRepository.findById(VehicleStatusId);
    }


    public void removeVehicleStatus(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }
}
