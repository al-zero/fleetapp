package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.Employee;
import alphasabawu.co.zw.fleetapp.models.User;
import alphasabawu.co.zw.fleetapp.repositories.EmployeeRepository;
import alphasabawu.co.zw.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;
    // Get Employees
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    // Add Employees
    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeByID(int id) {
        return employeeRepository.findById(id);
    }

    public void removeEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee findByUsername(String un) {
        return employeeRepository.findByUsername(un);
    }

    // Set the username of the employee where firstname and lastname match
//    public void assignUsername(int id){
//        Employee employee = employeeRepository.findById(id).orElse(null);
//        User user = userRepository.findByFirstNameAndLastname(
//                employee.getFirstname(),
//                employee.getLastname());
//        employee.setUsername(user.getUsername());
//        employeeRepository.save(employee);
//
//    }
}
