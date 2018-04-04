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

    @OneToOne
    @Column(name="category")
    private ActivityCategory category;
    private Date date;
    private Time startTime;
    private Time endTime;
    private String activityStatus;

}
