package be.vdab.crm.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "zip_code")
    @Pattern(regexp = "^\\d{1,4}$")
    private String zipCode;

    @Size(min = 2, max = 100)
    private String city;

    @Size(min = 2, max = 100)
    @Column(name = "street_name")
    private String streetName;

    @Column(name = "house_number")
    @Pattern(regexp = "^\\d{1,3}$")
    private String houseNumber;

    @Pattern(regexp = "^\\d{1,3}$")
    private String bus;


    /*Used by JPA*/
    protected Address() {
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

}
