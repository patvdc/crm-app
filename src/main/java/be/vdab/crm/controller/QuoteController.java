package be.vdab.crm.controller;

import be.vdab.crm.entity.*;
import be.vdab.crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private UserService userService;

    @Autowired
    private QuoteLineService quoteLineService;

    @PostMapping({"create/{contactId}"})
    public String postForm(@PathVariable(required = false) Integer contactId,
                           @ModelAttribute("quote") Quote quote, BindingResult br) {



        Contact contact = contactService.findContactById(contactId);
        quote.setContact(contact);
        quote.setOwner(contact.getOwner()); // Temporary solution until security subsystem is more full featured...
        refreshSalesNumbers(quote);
        quoteService.save(quote);
        System.out.println("PROCESSING FORM PSOT: " + quote + " CID: " + contactId + ", OID: " + contact.getOwner().getId() );
        return "redirect:/contacts/details/{contactId}";    // TODO
    }

    public void refreshSalesNumbers(Quote quote) {
        double total = 0;
        for (QuoteLine line : quote.getLines()) {
            line.setProduct(productService.getProductById(line.getProduct().getId()));
            line.setPrice(line.getProduct().getPrice());
            line.setTotal(line.getPrice() * line.getQuantity());
            total += line.getTotal();
        }
        quote.setTotal(total);
    }

    @GetMapping({"create/{contactId}"})
    public String createQuoteForm(@PathVariable(required = false) Integer contactId, Map<String,Object> map) {
        map.put("quote", new Quote());
        map.put("contact", contactService.findContactById(contactId));
        map.put("products", productService.getAllProducts());

        return "quote-create";
    }

    @GetMapping("details/{id}")
    public String quoteDetails(@PathVariable Integer id, Map<String, Object> model) {
        model.put("quote", quoteService.findQuoteById(id));
        return "contact-details";
    }

    @GetMapping("quote/create/{quoteLineId}")
    public String addQuoteLine(@PathVariable Integer quoteId, Map<String, Object> map)  {
        return "quote-create";
    }


}
