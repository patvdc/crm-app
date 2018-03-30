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
<<<<<<< HEAD
    @OneToMany
    private Address address;
    private Blob picture;    //??facebook api
=======
    @Column(name="street_name")
    private String streetName;
    @Column(name="street_nr")
    private String streetNr;
    @Column(name="zip")
    private String zip;
    @Column(name="city")
    private String city;
    private Blob picture;
    @OneToOne
    @Column(name="lead_status")
>>>>>>> 010af0b5a98f21392ac1815ebdafd1c3281f304d
    private LeadStatus leadStatus;
    private String email;     //?? validation util using pattern


}
