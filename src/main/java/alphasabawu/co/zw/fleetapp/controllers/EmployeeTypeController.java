package alphasabawu.co.zw.fleetapp.controllers;

import alphasabawu.co.zw.fleetapp.models.EmployeeType;
import alphasabawu.co.zw.fleetapp.models.JobTitle;
import alphasabawu.co.zw.fleetapp.services.EmployeeTypeService;
import alphasabawu.co.zw.fleetapp.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {


    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeTypes")
    public String getEmployeeType(Model model){
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypeList);

        return "employeeType";
    }


    @PostMapping("/employeeTypes/addNew")
    public String addEmployeeTypes(EmployeeType employeeType){
        employeeTypeService.saveEmployeeType(employeeType);
        return "redirect:/employeeType";
    }

    @RequestMapping("/employeeTypes/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(int id){
        return employeeTypeService.getEmployeeTypeByID(id);
    }

    @RequestMapping(value = "/employeeTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateEmployeeType(EmployeeType employeeType){
        employeeTypeService.saveEmployeeType(employeeType);
        return "redirect:/employeeType";
    }
    @RequestMapping(value = "/employeeTypes/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteEmployeeType(Integer id){
        employeeTypeService.removeEmployeeType(id);
        return "redirect:/employeeType";
    }
}
