package be.vdab.crm.repository;


import be.vdab.crm.entity.Address;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

//    @Query("select * from addresses where contact_id = :id") // this is SQL not JPQL! Doesn't work!
    @Query("select c.addresses from Contact c where c.id = :id")
    List<Address> findAllByContactIdEquals(@Param("id") int id) ;

    // FOREIGN KEYS AS ASSOCIATIONS!!!
}
