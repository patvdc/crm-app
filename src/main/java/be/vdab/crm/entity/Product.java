package be.vdab.crm.entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double unitPrice;
    private ProductCategory category;
    private Blob picture;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return unitPrice;
    }

    public void setPrice(Long price) {
        this.unitPrice = price;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

}

