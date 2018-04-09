package be.vdab.crm.service;

import be.vdab.crm.entity.Address;
import be.vdab.crm.repository.AddressRepository;
import be.vdab.crm.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private ContactRepository contactRepository;

    public void save(Address address) {
        repository.save(address);
    }

    public Address findById(int id) {
        return repository.getOne(id);
    }

    public List<Address> getAllAddresses() {
        return repository.findAll();
    }

    public List<Address> getAllAddressesByContactId(int id) {
        return contactRepository.getOne(id).getAddresses();
//        return repository.findAllByContactIdEquals(id);
    }


}
