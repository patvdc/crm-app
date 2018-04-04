package be.vdab.crm.repository;


import be.vdab.crm.entity.Contact;
import be.vdab.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {


}
