package be.vdab.crm.controller;

import be.vdab.crm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping("list")
    public String listAllContacts(Map<String, Object> model){
        model.put("contactList",service.getAllContacts());
        return "contact-list";
    }
}
