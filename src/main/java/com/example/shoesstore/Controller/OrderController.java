package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.Order;
import com.example.shoesstore.Model.Requests.CreateOrderRequest;
import com.example.shoesstore.Service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    OrderService orderService;

    @PostMapping("/create")
    ResponseEntity<?> placeOrder(@RequestBody CreateOrderRequest request){
        orderService.placeOrder(request);
        return ResponseEntity.ok("Đặt Hàng Thành Công");
    }

    @PutMapping("/update/{ordId}")
    ResponseEntity<?> updateOrder(@PathVariable Long ordId, @RequestBody CreateOrderRequest request){
        orderService.updateOrder(ordId, request);
        return ResponseEntity.ok("Cập Nhập Đơn Hàng Thành Công");
    }

    @GetMapping("/user")
    ResponseEntity<List<Order>> listOrderByUser(@RequestParam("email") String email){
        List<Order> orderList = orderService.listOrderByUser(email);
        return ResponseEntity.ok(orderList);
    }
}
