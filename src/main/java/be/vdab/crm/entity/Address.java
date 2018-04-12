package be.vdab.crm.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "zip_code")
    @Pattern(regexp = "^\\d{4}$", message = "Not a valid zipcode")
    @NotNull(message = "Can't be empty")
    private String zipCode;

    @Size(min = 2, max = 100, message = "City name too long")
    @NotNull(message = "Can't be empty")
    private String city;

    @Size(min = 2, max = 100, message = "Streetname too long")
    @Column(name = "street_name")
    @NotNull(message = "Street number is required")
    private String streetName;

    @Column(name = "house_number")
    @NotNull(message = "House number is required")
    @Pattern(regexp = "^\\d{1,3}$", message = "Not a valid housenumber")
    private String houseNumber;

    @Pattern(regexp = "^\\d{1,3}$", message = "Not a valid busnumber")
    private String bus;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getBus() {
        return bus;
    }

    public String prettyAddress() {
        return this.streetName + " " +
                this.houseNumber+ ", " +
                (this.bus == null ? "" : "Bus : " + this.bus + ", ") +
                this.zipCode + " " +
                this.city;


    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public Address setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }
}
