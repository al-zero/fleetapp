package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.EmployeeType;
import alphasabawu.co.zw.fleetapp.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {
    @Autowired

    private EmployeeTypeRepository employeeTypeRepository;

    // Return a list countries
    public List<EmployeeType> getEmployeeTypes(){
        return employeeTypeRepository.findAll();
    }


    // Save new country
    public  void saveEmployeeType(EmployeeType EmployeeType){
        employeeTypeRepository.save(EmployeeType);
        // return ;
    }

    // Get country by ID
    public Optional<EmployeeType> getEmployeeTypeByID(int EmployeeTypeId){
        return employeeTypeRepository.findById(EmployeeTypeId);
    }


    public void removeEmployeeType(Integer id) {
        employeeTypeRepository.deleteById(id);
    }
}
