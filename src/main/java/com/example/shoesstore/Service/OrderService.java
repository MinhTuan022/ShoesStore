package com.example.shoesstore.Service;

import com.example.shoesstore.Model.Requests.CreateOrderRequest;

public interface OrderService {
    void placeOrder(CreateOrderRequest request);
}
