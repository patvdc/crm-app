package be.vdab.crm.service;

import be.vdab.crm.entity.Contact;
import be.vdab.crm.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContactService {

    @Autowired
    private ContactRepository repository;

    public void save(Contact contact) {
        repository.save(contact);
    }

    public Contact findContactById(int id){
        return repository.getOne(id);
    }

    public List<Contact> getAllContacts(){
        return repository.findAll();
    }

}
