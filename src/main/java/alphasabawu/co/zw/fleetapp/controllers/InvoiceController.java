package alphasabawu.co.zw.fleetapp.controllers;

import alphasabawu.co.zw.fleetapp.models.Client;
import alphasabawu.co.zw.fleetapp.models.Invoice;
import alphasabawu.co.zw.fleetapp.models.InvoiceStatus;
import alphasabawu.co.zw.fleetapp.services.ClientService;
import alphasabawu.co.zw.fleetapp.services.InvoiceService;
import alphasabawu.co.zw.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {
    
    
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private InvoiceStatusService invoiceStatusService;
    
    @GetMapping("/invoices")
    public String getInvoice(Model model){

        List<Invoice> invoiceList = invoiceService.getInvoices();
        List<Client> clientList = clientService.getClients();
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuss();

        model.addAttribute("invoices", invoiceList);
        model.addAttribute("clients", clientList);
        model.addAttribute("invoiceStatuses", invoiceStatusList);
     //   System.out.println("STATUS: " + invoiceStatusService);


        return "invoice";
    }

    @PostMapping("/invoices/addNew")
    public String addinvoice(Invoice invoice){
        invoiceService.saveInvoice(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping("/invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(int id){
        return invoiceService.getInvoiceByID(id);
    }


    @RequestMapping(value = "/invoices/edit", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateinvoice(Invoice invoice){
        invoiceService.saveInvoice(invoice);
        return "redirect:/invoices";
    }
    @RequestMapping(value = "/invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteinvoice(Integer id){
        invoiceService.removeInvoice(id);
        return "redirect:/invoices";
    }


}
