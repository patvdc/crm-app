package be.vdab.crm.entity;


import javax.persistence.*;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Enumerated(EnumType.STRING)
    private LeadStatus leadStatus;

    private String email;

    @ManyToOne
    private User owner;     //owner of the lead - from user table

    @OneToMany
    @JoinColumn(name = "contact_id")
    private List<Address> addresses;

    @Enumerated(EnumType.STRING)
    private Salutation salutation;

    @Enumerated(EnumType.STRING)
    private LeadSource leadSource;

    private String accountName;    //Account

//    @OneToMany
//    @MapKey(name="type")
//    @JoinColumn(name = "test")
//    private Map<PhoneType, String> phones;

    private String facebook;   //api - later when time

    private String twitter;   //api - later when time

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() { return firstName + " " + lastName; }

    public Blob getPicture() {
        return picture;
    }

    public LeadStatus getLeadStatus() {
        return leadStatus;
    }

    public String getEmail() {
        return email;
    }

    public User getOwner() {
        return owner;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Salutation getSalutation() {
        return salutation;
    }

    public LeadSource getLeadSource() {
        return leadSource;
    }

    public String getAccountName() {
        return accountName;
    }

//    public Map<PhoneType, String> getPhones() {
//        return phones;
//    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
