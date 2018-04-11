package be.vdab.crm.api;

import be.vdab.crm.api.version.RestContact_1_0;
import be.vdab.crm.entity.Contact;
import be.vdab.crm.repository.ContactRepository;
import be.vdab.crm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;


@RestController
@RequestMapping("/api/contacts")
@Transactional
public class ContactRestController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactService contactService;


    @GetMapping(path = "/xml/v_1_0/{id}",produces = APPLICATION_XML_VALUE)
    public RestContact_1_0 get1(@PathVariable("id") int id) {
        Contact contact = contactRepository.getOne(id);   //or service
        return new RestContact_1_0(contact);
    }

    @GetMapping(path = "/json/v_1_0/{id}",produces = APPLICATION_JSON_VALUE)
    public RestContact_1_0 get2(@PathVariable("id") int id) {
        Contact contact = contactRepository.getOne(id);   //or service
        return new RestContact_1_0(contact);
    }


    @GetMapping(path = "/json/{id}",produces = APPLICATION_JSON_VALUE)
    public  Contact get3(@PathVariable("id") int id) {
        return contactRepository.getOne(id);
    }

    @GetMapping(path = "/xml/list",produces = APPLICATION_XML_VALUE)
    public List<Contact> get4() {
        return contactRepository.findAll();
    }

    @GetMapping(path = "/json/list",produces = APPLICATION_JSON_VALUE)
    public List<Contact> get5() {
        return contactRepository.findAll();
    }

    @RequestMapping("/")
    public String index() {
        return "The CRM Company - Rest Controller - Contact";
    }

}

/*

http://localhost:8080/api/contact/1

authentication ?
 */