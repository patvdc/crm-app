package be.vdab.crm.entity;

import javax.persistence.*;

@Entity
@Table(name = "activity_category")
public class ActivityCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="value")
    private String activityCategory;

}


