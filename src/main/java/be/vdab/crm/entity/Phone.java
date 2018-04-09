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

    public PhoneType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public Integer getId() {
        return id;
    }


}
