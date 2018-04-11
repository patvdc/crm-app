package be.vdab.crm.api;

import be.vdab.crm.api.version.RestContact_1_0;
import be.vdab.crm.entity.Contact;
import be.vdab.crm.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;


@RestController
@RequestMapping("/api/contact/")
@Transactional
public class ContactRestController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping(path = "{id}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public RestContact_1_0 get(@PathVariable("id") int id) {
        Contact contact = contactRepository.getOne(id);   //or service
        return new RestContact_1_0(contact);
    }
}

/*
http://localhost:8080/api/contact/1
 */