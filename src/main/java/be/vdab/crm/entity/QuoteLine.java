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
    private Product product = new Product();

    private int quantity;

    private double price;

    private double total;

    public QuoteLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = this.product.getUnitPrice();
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

    public double getTotal() {
        return total;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Used by Spring MVC form binding. Consider separating domain model from form objects for security and encapsulation!!
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Used by Spring MVC form binding. Consider separating domain model from form objects for security and encapsulation!!
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Used by Spring MVC form binding. Consider separating domain model from form objects for security and encapsulation!!
     */
    public void setTotal(double total) {
        this.total = total;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
