package be.vdab.crm.repository;

import be.vdab.crm.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    @Query("select a from Activity a where a.contact.id = :contactId")
    List<Activity> findAllByContactId(@Param("contactId")Integer id);

//    @Query("select contact.id from activities where id = :id")
//    @Query("select c from Contact c join c.activities where a.id = :id")
//    Contact getContactIdByActivity(@Param("id") int activityId);


}
