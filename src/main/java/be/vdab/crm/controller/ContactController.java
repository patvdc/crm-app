package be.vdab.crm.controller;

import be.vdab.crm.entity.Contact;
import be.vdab.crm.service.ContactService;
import be.vdab.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private UserService userService;

    @GetMapping("list")
    public String listAllContacts(Map<String, Object> model){
        model.put("contactList",contactService.getAllContacts());
        return "contact-list";
    }

    @GetMapping("edit-create/{id}")
    public String editOrCreateContact(@PathVariable(required = false) Integer id, Map<String, Object> model){
        model.put("contact", (id == null ? new Contact() : contactService.findContactById(id)));
        model.put("users", userService.getAllUsers());
        return "contact-edit-create";
    }
}
