package be.vdab.crm.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
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
    private List<Address> addresses = new ArrayList<>();

    private String accountName;    //Account

    /**
     * orphanRemoval to make sure entries get deleted from database when phone is deleted from contact
     * cascade to make sure phones get persisted, merged and removed along with contact
     */
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE }, orphanRemoval = true)
    @MapKey(name = "type")
    @JoinColumn(name = "contact_id")
    private Map<PhoneType, Phone> phones = new HashMap<>();

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

    public String getFullName() {
        return firstName == null ? "" : firstName + " " + lastName == null ? "" : lastName;
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

    public void addPhone(Phone phone) {
        phones.put(phone.getType(),phone);
    }
}
