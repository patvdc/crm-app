package be.vdab.crm.service;

import be.vdab.crm.entity.Address;
import be.vdab.crm.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public void save(Address address) {
        repository.save(address);
    }

}
