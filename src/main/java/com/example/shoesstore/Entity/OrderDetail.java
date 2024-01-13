package com.example.shoesstore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int size;
    private int quantity;
    private long subTotal;

    @ManyToOne
    @JoinColumn(name ="ord_Id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "pro_Id")
    private Product product;
}
