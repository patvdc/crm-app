package be.vdab.crm.api.version;

import be.vdab.crm.entity.Contact;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contact")
public class RestContact_1_0 {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public RestContact_1_0() {
    }

    public RestContact_1_0(Contact contact) {

        setFirstName(contact.getFirstName());
        setLastName(contact.getLastName());
        setEmail(contact.getEmail());

    }

    @JsonProperty("first_name")
    @XmlElement(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("last_name")
    @XmlElement(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
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
}
