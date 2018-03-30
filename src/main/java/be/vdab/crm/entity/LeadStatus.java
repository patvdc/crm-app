package be.vdab.crm.entity;

import javax.persistence.*;

@Entity
@Table(name = "lead_status")
public class LeadStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="category")
    private String category;


}
