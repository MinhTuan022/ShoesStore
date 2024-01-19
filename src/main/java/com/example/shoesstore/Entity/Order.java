package com.example.shoesstore.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ordId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ordDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ordShipDate;

    @Column(columnDefinition = "TEXT")
    private String ordAddress;

    private String ordPhone;
    private String ordReceiver;
    private long ordTotal;

    @ManyToOne
    @JoinColumn(name = "pay_Id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "cus_Id")
    private User customer;

    @OneToMany(mappedBy = "order")
    @JsonBackReference
    private Set<OrderDetail> orderDetail;


}
