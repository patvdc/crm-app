package be.vdab.crm.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;
import java.util.*;


//create note, activity (meeting, call-in, call-out


@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name",length=50)
    @Size(max = 50, message = "Maximum 50 characters")
    private String firstName;

    @Column(name="last_name",length=100)
    @Size(max = 100, message = "Maximum 100 characters")
    private String lastName;

    private Blob picture;

    @Enumerated(EnumType.STRING)
    @NotNull
    private LeadStatus leadStatus;

    @Email(message = "Must be a valid email address")
    @Column(length=50)
    private String email;

    @ManyToOne
    private User owner;     //owner of the lead - from user table

    @OneToMany
    @JoinColumn(name = "contact_id")
    private List<Address> addresses = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "contact_id")
    private List<Activity> activities = new ArrayList<>();

    /**
     * orphanRemoval to make sure entries get deleted from database when phone is deleted from contact
     * cascade to make sure phones get persisted, merged and removed along with contact
     */
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE }, orphanRemoval = true)
    @MapKey(name = "type")
    @JoinColumn(name = "contact_id")
    private Map<PhoneType, Phone> phones = new HashMap<>();

    @Transient
    private String facebook;   //api - later when time
    @Transient
    private String twitter;   //api - later when time
    @Transient
    private String accountName;    //Account -> company, later

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return (firstName == null ? "" : firstName) + " " + (lastName == null ? "" : lastName);
    }

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

    public List<Address> getAddresses() { return Collections.unmodifiableList(addresses); }

    public void setAddresses(List<Address> addresses) { this.addresses = addresses; }

    public void addAddress(Address address) {
        if(address == null) {
            throw new IllegalArgumentException("Invalid Address");
        }
        this.addresses.add(address);
    }

    public List<Activity> getActivities() { return activities; }

    public void setActivities(List<Activity> activities) { this.activities = activities; }

    public void addActiviy(Activity activity) {
        if(activity == null) {
            throw new IllegalArgumentException("Invalid Activity");
        }
        this.activities.add(activity);
    }

    public String getAccountName() {
        return accountName;
    }

    public Map<PhoneType, Phone> getPhones() {
        return phones;
    }

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

    public void setPhones(Map<PhoneType, Phone> phones) {
        this.phones = phones;
    }

    public void setLeadStatus(LeadStatus leadStatus) {
        this.leadStatus = leadStatus;
    }

    public void addPhone(Phone phone) {
        phones.put(phone.getType(),phone);
    }
}
