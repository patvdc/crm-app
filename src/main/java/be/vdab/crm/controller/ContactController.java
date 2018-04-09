package be.vdab.crm.controller;

import be.vdab.crm.entity.Contact;
import be.vdab.crm.entity.PhoneType;
import be.vdab.crm.entity.User;
import be.vdab.crm.service.ContactService;
import be.vdab.crm.service.QuoteService;
import be.vdab.crm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.expression.Mvc;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private ContactService contactService;
    @Autowired
    private UserService userService;
    @Autowired
    private Mvc mvc;
    @Autowired
    private QuoteService quoteservice;

    @GetMapping("list")
    public String listAllContacts(Map<String, Object> model) {
        model.put("contactList", contactService.getAllContacts());
        return "contact-list";
    }

    @GetMapping({"edit-create/{id}", "edit-create"})
    public String editOrCreateContactRequest(@PathVariable(required = false) Integer id, Map<String, Object> model) {
        model.put("contact", (id == null ? new Contact() : contactService.findContactById(id)));
        model.put("owners", userService.getAllUsers());
        return "contact-edit-create";
    }

    //used pathvariable instead
//    @GetMapping("edit-create")
//    public String editOrCreateContactRequest(@RequestParam(value="id", required = false) Integer id, Map<String, Object> model) {
//        model.put("contact", (id == null ? new Contact() : contactService.findContactById(id)));
//        model.put("owners", userService.getAllUsers());
//        return "contact-edit-create";
//    }

    //TODO: a way to do this without request?
    @PostMapping({"edit-create/{id}", "edit-create"})
    public String editOrCreateContactPost(@PathVariable(required = false) Integer id, @ModelAttribute("contact") Contact contact
            ,Map<String, Object> model, BindingResult br) {


        if (contact.getEmail().equals("") && contact.getPhones() == null) {
            br.addError(new FieldError("contact", "email", "Contact needs email or phone number"));
            br.addError(new FieldError("contact", "phones", "Contact needs phone number or email"));
        }
        if (br.hasErrors()) {
            model.put("owners", userService.getAllUsers());
            return "contact-edit-create";
        } else {
            contactService.save(contact);
            return "redirect:" + mvc.url("CC#listAllContacts").build();
        }
    }

    @GetMapping("details/{id}")
    public String contactDetails(@PathVariable Integer id, Map<String, Object> model) {
        model.put("contact", contactService.findContactById(id));
        model.put("quoteList", quoteservice.getAllQuotesByContactId(id));
        return "contact-details";
    }
}
