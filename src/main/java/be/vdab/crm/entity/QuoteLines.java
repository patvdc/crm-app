package be.vdab.crm.entity;

import javax.persistence.*;

//Quote lines

@Entity
@Table(name = "quote_lines")
public class QuoteLines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Quote quote;
    private Product product;
    private int quantity;
    private Product productPrice;
    private long total;

    public QuoteLines() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Product productPrice) {
        this.productPrice = productPrice;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }


}
