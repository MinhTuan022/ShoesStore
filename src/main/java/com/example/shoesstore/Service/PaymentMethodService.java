package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethod> getAllMethod();

    PaymentMethod createPaymentMethod(PaymentMethod paymentMethod);


}
