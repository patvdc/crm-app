package be.vdab.crm.repository;


import be.vdab.crm.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Integer> {


}
