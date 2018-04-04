package be.vdab.crm.controller;

import be.vdab.crm.entity.Contact;
import be.vdab.crm.service.ContactService;
import be.vdab.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.expression.Mvc;

import java.util.Map;

@Controller
@RequestMapping("/contacts")
public class ContactController {

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

//    @GetMapping("edit-create/{id}")
//    public String editOrCreateContactRequest(@PathVariable(required = false) Integer id, Map<String, Object> model){
//        model.put("contact", (id == null ? new Contact() : contactService.findContactById(id)));
//        model.put("owners", userService.getAllUsers());
//        return "contact-edit-create";
//    }

    @GetMapping("edit-create")
    public String editOrCreateContactRequest(@RequestParam(value="id", required = false) Integer id, Map<String, Object> model) {
        model.put("contact", (id == null ? new Contact() : contactService.findContactById(id)));
        model.put("owners", userService.getAllUsers());
        return "contact-edit-create";
    }

    @PostMapping("edit-create")
    public String editOrCreateContactPost(@ModelAttribute("contact") Contact contact) {
        contactService.save(contact);
        return "redirect:" + mvc.url("CC#listAllContacts").build();
    }
}
