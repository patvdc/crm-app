package be.vdab.crm.entity;

import javax.persistence.*;

//Quote lines

@Entity
@Table(name = "quote_lines")
public class QuoteLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Product product;

    private int quantity;

    private double price;

    private double total;

    public QuoteLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = this.product.getPrice();
        this.total = this.quantity * this.price;
    }

    /**
     * Used by JPA.
     */
    public QuoteLine() {
    }

    public Integer getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return total;
    }


}
