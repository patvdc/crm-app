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

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    private Blob picture;

    public Product() {
    }

    public Product(String name, double unitPrice, ProductCategory category) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.category = category;
    }

    public Integer getId() {
        return id;
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

    public void setPrice(double price) {
        this.unitPrice = price;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}

