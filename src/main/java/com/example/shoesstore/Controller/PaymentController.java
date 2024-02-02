package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.PaymentMethod;
import com.example.shoesstore.Service.PaymentMethodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {
    PaymentMethodService paymentMethodService;
    @GetMapping
    ResponseEntity<List<PaymentMethod>> getAllPaymentMethod(){
        List<PaymentMethod> paymentMethodList = paymentMethodService.getAllMethod();
        return ResponseEntity.ok(paymentMethodList);
    }

    @PostMapping("/create")
    ResponseEntity<PaymentMethod> createMethod(@RequestBody PaymentMethod paymentMethod){
        PaymentMethod paymentMethod1 = paymentMethodService.createPaymentMethod(paymentMethod);
        return ResponseEntity.ok(paymentMethod1);
    }
}
