package be.vdab.crm.entity;

import javax.persistence.*;

@Entity
@Table(name = "lead_source")
public class LeadSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="value")
    private String leadSource;

}


