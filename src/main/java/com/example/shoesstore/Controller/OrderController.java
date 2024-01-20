package com.example.shoesstore.Controller;

import com.example.shoesstore.Model.Requests.CreateOrderRequest;
import com.example.shoesstore.Service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    ResponseEntity<?> placeOrder(@RequestBody CreateOrderRequest request){
        orderService.placeOrder(request);
        return ResponseEntity.ok("Đặt Hàng Thành Công");
    }
}
