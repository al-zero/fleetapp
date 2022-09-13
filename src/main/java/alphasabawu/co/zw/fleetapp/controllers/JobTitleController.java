package alphasabawu.co.zw.fleetapp.controllers;

import alphasabawu.co.zw.fleetapp.models.JobTitle;
import alphasabawu.co.zw.fleetapp.models.VehicleStatus;
import alphasabawu.co.zw.fleetapp.services.JobTitleService;
import alphasabawu.co.zw.fleetapp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/jobTitles")
    public String getJobTitle(Model model){

        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
        model.addAttribute("jobTitles",jobTitleList);
        return "jobTitle";
    }

    @PostMapping("/jobTitles/addNew")
    public String addJobTitles(JobTitle jobTitle){
        jobTitleService.saveJobTitle(jobTitle);
        return "redirect:/jobTitle";
    }

    @RequestMapping("/jobTitles/findById")
    @ResponseBody
    public Optional<JobTitle> findById(int id){
        return jobTitleService.getJobTitleByID(id);
    }

    @RequestMapping(value = "/jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateJobTitle(JobTitle jobTitle){
        jobTitleService.saveJobTitle(jobTitle);
        return "redirect:/jobTitle";
    }
    @RequestMapping(value = "/jobTitles/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteJobTitle(Integer id){
        jobTitleService.removeJobTitle(id);
        return "redirect:/jobTitle";
    }

}
