package alphasabawu.co.zw.fleetapp.controllers;

import alphasabawu.co.zw.fleetapp.models.EmployeeType;
import alphasabawu.co.zw.fleetapp.models.InvoiceStatus;
import alphasabawu.co.zw.fleetapp.services.EmployeeTypeService;
import alphasabawu.co.zw.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoiceStatuses")
    public String getInvoiceStatus(Model model){

        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuss();
        model.addAttribute("invoiceStatuses", invoiceStatusList);

        return "invoiceStatus";
    }


    @PostMapping("/invoiceStatuses/addNew")
    public String addInvoiceStatuses(InvoiceStatus invoiceStatus){
        invoiceStatusService.saveInvoiceStatus(invoiceStatus);
        return "redirect:/invoiceStatus";
    }

    @RequestMapping("/invoiceStatuses/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(int id){
        return invoiceStatusService.getInvoiceStatusByID(id);
    }

    @RequestMapping(value = "/invoiceStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateInvoiceStatuses(InvoiceStatus invoiceStatus){
        invoiceStatusService.saveInvoiceStatus(invoiceStatus);
        return "redirect:/invoiceStatus";
    }
    @RequestMapping(value = "/employeeTypes/deleteById", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteInvoiceStatus(Integer id){
        invoiceStatusService.removeInvoiceStatus(id);
        return "redirect:/invoiceStatus";
    }
}
