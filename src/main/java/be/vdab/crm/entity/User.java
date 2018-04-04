package be.vdab.crm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;    //must be saved as encrypted value
    private Integer active;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private Language language;

    private Blob picture;

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public Integer getId() {
        return id;
    }
}
