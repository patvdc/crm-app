package be.vdab.crm.entity;

import javax.persistence.*;

//contact can have multiple notes

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="value")
    private String comment;

}
