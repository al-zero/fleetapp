package alphasabawu.co.zw.fleetapp.controllers;


import alphasabawu.co.zw.fleetapp.models.*;
import alphasabawu.co.zw.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobTitleService jobTitleService;

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/employees")
    public String getEmployee(Model model){

        List<Employee> employeeList = employeeService.getEmployees();
        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();

        model.addAttribute("employees", employeeList);
        model.addAttribute("jobTitles", jobTitleList);
        model.addAttribute("employeeTypes", employeeTypeList);
        model.addAttribute("states",stateList);
        model.addAttribute("countries", countryList);
        

        return "employee";
    }


    @PostMapping("/employee/addNew")
    public String addEmployee(Employee Employee){
        employeeService.saveEmployee(Employee);
        return "redirect:/employees";
    }

    @RequestMapping("/employee/findById")
    @ResponseBody
    public Optional<Employee> findById(int id){
        return employeeService.getEmployeeByID(id);
    }


    @RequestMapping(value = "/employee/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateEmployee(Employee Employee){
        employeeService.saveEmployee(Employee);
        return "redirect:/employees";
    }
    @RequestMapping(value = "/employee/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteEmployee(Integer id){
        employeeService.removeEmployee(id);
        return "redirect:/employees";
    }

//    @RequestMapping(value = "/employees/assignUsername")
//    public String assignUsername(int id){
//        employeeService.assignUsername(id);
//        return "redirect:/employees";
//    }
}
