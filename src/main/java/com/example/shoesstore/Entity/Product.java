package com.example.shoesstore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long proId;
    private String proName;
    private Double proPrice;
    private Double proBasisPrice;
    private Date proDate;
    private boolean proHot;
    private boolean proState;

    @Column(name = "pro_Description",columnDefinition = "TEXT")
    private String proDescription;
    private int proQuantity;

    @ManyToOne
    @JoinColumn(name = "cate_Id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "bra_Id")
    private Brand brand;

    @ManyToMany
    @JoinTable(name = "product_image",joinColumns = @JoinColumn(name="pro_Id"),inverseJoinColumns = @JoinColumn(name="img_Id"))
    private Set<Image> images = new HashSet<>();
}
