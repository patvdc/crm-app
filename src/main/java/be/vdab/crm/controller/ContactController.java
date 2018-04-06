package be.vdab.crm.controller;

import be.vdab.crm.entity.Contact;
import be.vdab.crm.service.ContactService;
import be.vdab.crm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.spring5.expression.Mvc;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    //TODO: validate one field not null
    @PostMapping("edit-create")
    public String editOrCreateContactPost(@ModelAttribute("contact") Contact contact, HttpServletRequest req) {
        if(req.getParameter("owner") != null) {
            contact.setOwner(userService.getUserById(Integer.parseInt(req.getParameter("owner"))));
        }
        if(contact.getEmail()!= "" || contact.getFirstName() != "" || contact.getLastName() != "") {
            contactService.save(contact);
        }
        return "redirect:" + mvc.url("CC#listAllContacts").build();
    }

    @GetMapping("details/{id}")
    public String contactDetails(@PathVariable Integer id, Map<String, Object> model) {
        model.put("contact", contactService.findContactById(id));
        return "contact-details";
    }
}
