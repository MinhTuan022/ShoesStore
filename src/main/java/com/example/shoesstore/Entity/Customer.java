package com.example.shoesstore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cusId;

    @Column(unique = true)
    private String cusUser;
    private String cusPass;
    private String cusPhone;

    @Column(columnDefinition = "TEXT")
    private String cusAddress;

    @Column(unique = true)
    private String cusEmail;
}
