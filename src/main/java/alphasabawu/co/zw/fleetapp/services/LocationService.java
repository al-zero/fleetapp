package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.Location;
import alphasabawu.co.zw.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // Return a list countries
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }


    // Save new country
    public  void saveLocation(Location location){
        locationRepository.save(location);
        // return ;
    }

    // Get country by ID
    public Optional<Location> getLocationByID(int locationId){
        return locationRepository.findById(locationId);
    }


    public void removeLocation(Integer id) {
        locationRepository.deleteById(id);
    }
}
