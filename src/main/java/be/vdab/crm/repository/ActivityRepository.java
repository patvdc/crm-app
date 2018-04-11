package be.vdab.crm.repository;

import be.vdab.crm.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

//    @Query("select contact.id from activities where id = :id")
//    @Query("select c from Contact c join c.activities where a.id = :id")
//    Contact getContactIdByActivity(@Param("id") int activityId);


}
