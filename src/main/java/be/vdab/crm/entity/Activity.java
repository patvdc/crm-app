package be.vdab.crm.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ActivityCategory category;

    private Date date;   //date of meeting,call/todo
    private Time startTime;    //when started
    private Time endTime;    //when stopped
    private String comment;     // saying that ..........
    private String subject;    //meeting @ customer x

    private ActivityStatus status;    //open  -> not yet done , closed -> done

    @ManyToOne
    private User owner;   //later

}
