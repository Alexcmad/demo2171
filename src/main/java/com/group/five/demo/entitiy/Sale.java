package com.group.five.demo.entitiy;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private Date date;
    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customerId" , nullable = false)
    private Customer customer;

    @Column
    private float total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }
}
