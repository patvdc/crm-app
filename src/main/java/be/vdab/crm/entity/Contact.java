package be.vdab.crm.entity;


import javax.persistence.*;
import java.sql.Blob;
import java.util.List;


//create note, activity (meeting, call-in, call-out


@Entity
@Table(name = "contacts")
public class Contact implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name",length=50)
    private String firstName;

    @Column(name="last_name",length=100)
    private String lastName;

    private Blob picture;

    private LeadStatus leadStatus;

    private String email;

    @ManyToOne
    private User owner;     //owner of the lead - from user table

    @OneToMany
    @JoinColumn(name = "contact_id")
    private List<Address> addresses;

    private Salutation salutation;

    private LeadSource leadSource;

    private String accountName;    //Account

    private String phone;      //fix phone

    private String mobile;    //gsm

    private String facebook;   //api

    private String twitter;   //api

}
