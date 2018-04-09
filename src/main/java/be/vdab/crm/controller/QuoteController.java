package be.vdab.crm.controller;

import be.vdab.crm.entity.*;
import be.vdab.crm.repository.QuoteRepository;
import be.vdab.crm.service.AddressService;
import be.vdab.crm.service.ContactService;
import be.vdab.crm.service.ProductService;
import be.vdab.crm.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AddressService addressService;

    @PostMapping({"create/{contactId}"})
    public String postForm(@PathVariable(required = false) Integer contactId, @ModelAttribute("quote") Quote quote, BindingResult br) {
        System.out.println("PROCESSING FORM PSOT: " + quote + " CID: " + contactId);
        return "redirect:/";    // TODO
    }

    @GetMapping({"create/{id}"})
    public String createQuoteForm(@PathVariable(required = false) Integer id, Map<String,Object> map) {
        Contact c = contactService.findContactById(id);
        List<Address> a = c.getAddresses();
        Quote q = new Quote();
        q.setContact(c);
        List<Product> p = productService.getAllProducts();
        map.put("products",p);
        map.put("quote",q);
        map.put("addresses",a);
        return "quote-create";
    }

    @GetMapping("details/{id}")
    public String quoteDetails(@PathVariable Integer id, Map<String, Object> model) {
        model.put("quote", quoteService.findQuoteById(id));
        return "contact-details";
    }


}
