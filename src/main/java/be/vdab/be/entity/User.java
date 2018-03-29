package be.vdab.be.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private Integer active;   //0 or 1 ; boolean? enum?
    private String firstName;
    private String lastName;
    private String language;    // enum? database -> used for language switch
}
