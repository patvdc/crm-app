package be.vdab.crm.entity;

import javax.persistence.*;

@Entity
@Table(name = "quote_lines")
public class QuoteLines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   //1,2,3,...
    private Product productId;
    private int quantity;
    private Product productPrice;
    private long total;

}
