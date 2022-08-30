package alphasabawu.co.zw.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobTitleController {
    @GetMapping("/jobTitles")
    public String getJobTitle(){
        return "jobTitle";
    }
}
