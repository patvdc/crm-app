package be.vdab.crm.service;


import be.vdab.crm.entity.User;
import be.vdab.crm.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public List<User> findAll() {
        return repository.findAll(new Sort(Sort.Direction.ASC, "email"));
    }

    public void save(User u) {
        repository.save(u);
    }

    //TODO -> xref ?
    public User lookupUser(int id) {
        logger.info("Looking up user with UID " + id);
        return repository.getOne(id);
    }

    public User getUserById(int id) {
        return repository.getOne(id);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
