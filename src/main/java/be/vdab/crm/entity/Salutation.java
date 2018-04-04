package be.vdab.crm.entity;

import javax.persistence.*;

@Entity
@Table(name = "salutation")
public class Salutation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="value")
    private String salutation;

}
