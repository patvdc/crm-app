package be.vdab.crm.entity;


import javax.persistence.*;


@Entity
@Table(name = "phone_numbers")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    private String number;

    public Phone() {
    }

    public Phone(String number, PhoneType type) {
        this.number = number;
        this.type = type;
    }

    public PhoneType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public Integer getId() {
        return id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
