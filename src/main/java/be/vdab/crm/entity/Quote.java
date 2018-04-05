package be.vdab.crm.entity;

import javax.persistence.*;
import java.util.List;

//Quote header

@Entity
@Table(name = "quote")
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

    @OneToMany
//    @JoinColumn(name = "quote_id")
    private List<QuoteLines> lines;

    private long total ;    //sum of quote lines total

    public Quote() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<QuoteLines> getLines() {
        return lines;
    }

    public void setLines(List<QuoteLines> lines) {
        this.lines = lines;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}



