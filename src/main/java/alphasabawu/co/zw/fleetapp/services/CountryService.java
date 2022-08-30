package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.Country;
import alphasabawu.co.zw.fleetapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Return a list countries
    public List<Country> getCountries(){
        return countryRepository.findAll();
    }


    // Save new country
    public  void saveCountry(Country country){
        countryRepository.save(country);
       // return ;
    }

    // Get country by ID
    public Optional<Country> getCountryByID(int countryId){
        return countryRepository.findById(countryId);
    }


    public void removeCountry(Integer id) {
         countryRepository.deleteById(id);
    }
}
