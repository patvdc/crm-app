package be.vdab.crm.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class QuoteLines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   //1,2,3,...
    private Product productId;
    private int quantity;
    private Product productPrice;
    private long total;

}
