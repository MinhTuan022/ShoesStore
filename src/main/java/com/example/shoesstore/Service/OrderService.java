package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Order;
import com.example.shoesstore.Model.Requests.CreateOrderRequest;

import java.util.List;

public interface OrderService {
    void placeOrder(CreateOrderRequest request);

    void updateOrder(Long ordId, CreateOrderRequest request);

    List<Order> listOrderByUser(String email);
}
