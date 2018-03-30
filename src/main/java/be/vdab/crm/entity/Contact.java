package be.vdab.crm.entity;


import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

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

    private Blob picture;    //??facebook api

    @OneToOne
    @JoinColumn(name="lead_status")
    private LeadStatus leadStatus;

    private String email;     //?? validation util using pattern

    @OneToMany
    @JoinColumn(name = "contact_id")
    private List<Address> addresses;


}
