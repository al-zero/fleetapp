package alphasabawu.co.zw.fleetapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EmployeeController {

    @GetMapping("/employees")
    public String getEmployee(){
        return "employee";
    }
}
