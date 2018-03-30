package be.vdab.crm.entity;


import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @OneToMany
    private Address address;
    private Blob picture;    //??facebook api
    private LeadStatus leadStatus;
    private String email;     //?? validation util using pattern


}
