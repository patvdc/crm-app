package be.vdab.crm.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;    //must be saved as encrypted value
    private Integer active;
    private String firstName;
    private String lastName;
    private Language language;

    private Blob picture;
}
