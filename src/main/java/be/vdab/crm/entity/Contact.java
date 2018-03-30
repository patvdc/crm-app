package be.vdab.crm.entity;


import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String streetName;
    private String streetNr;
    private String zip;
    private String city;
    private byte image;    //picture - blob -> facebook api getPicture
    private LeadStatus leadStatus;
    private String email;     //validation ? utility

}
