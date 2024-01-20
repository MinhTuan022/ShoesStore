package com.example.shoesstore.Model.Requests;

import com.example.shoesstore.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDetailRequest {
    private int size;
    private int quantity;
    private long subTotal;
    private long proId;
}
