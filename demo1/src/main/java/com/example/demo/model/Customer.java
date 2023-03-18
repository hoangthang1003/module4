package com.example.demo.dto;


import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String customer;
    private String img;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id" , referencedColumnName = "customer_type")
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(long id, String customer, String img, CustomerType customerType) {
        this.id = id;
        this.customer = customer;
        this.img = img;
        this.customerType = customerType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
