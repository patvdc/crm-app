package be.vdab.crm.entity;

import javax.persistence.*;

// to maintain all keywords
@Entity
@Table(name = "keyword")
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String category;     //Leadsource, Language, Leadstatus, ...
    private String value;        //

}
