package be.vdab.crm.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Quote header

@Entity
@Table(name = "quotes")
public class Quote implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private QuoteStage stage;

    @ManyToOne
    private User owner;

    @OneToOne
    private Contact contact;

    @OneToOne
    private Address billingAddress;

    @OneToOne
    private Address shippingAddress;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "quote_id")
    private List<QuoteLine> lines = new ArrayList<>();

    private double total = 0;    //sum of quote lines total

    public Quote() {
    }

    public Integer getId() {
        return id;
    }

    public QuoteStage getStage() {
        return stage;
    }

    public void setStage(QuoteStage stage) {
        this.stage = stage;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) { this.owner = owner; }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) { this.contact = contact; }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * Not an Unmodifiable collection due to it being used in Spring MVC form binding. Consider separating domain objects from form processing for security and encapsulation.
     */
    public List<QuoteLine> getLines() {
        return lines;
    }

    public void addLine(QuoteLine line) {
        if(line == null) {
            throw new IllegalArgumentException("Invalid quoteline");
        }
        this.lines.add(line);
        this.total += line.getTotal();
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}



