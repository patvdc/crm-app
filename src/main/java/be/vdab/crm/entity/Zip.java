package be.vdab.crm.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Zip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;         //1
    private String code;    //9000
    private String city;    //Gent
}
