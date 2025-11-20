package com.retail.rewards.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_email")
    private String email;

    @Override
    public String toString() {
        return "{\n" +
                "    \"customerId\": " + customerId + ",\n" +
                "    \"Name\" : " + name + ",\n" +
                "    \"Email\": " + email + "\n" +
                "}";
    }

}
