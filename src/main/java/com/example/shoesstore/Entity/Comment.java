package com.example.shoesstore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cmtId;
    private String cmtContent;
    private String cmtDate;
    private boolean cmtState;

    @ManyToOne
    @JoinColumn(name = "pro_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "u_id", nullable = false)
    private User user;
}
