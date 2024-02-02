package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.PaymentMethod;
import com.example.shoesstore.Repository.PaymentRepository;
import com.example.shoesstore.Service.PaymentMethodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {

    PaymentRepository paymentRepository;
    @Override
    public List<PaymentMethod> getAllMethod() {
        return paymentRepository.findAll();
    }

    @Override
    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return paymentRepository.save(paymentMethod);
    }
}
