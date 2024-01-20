package com.example.shoesstore.Repository;

import com.example.shoesstore.Entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentMethod, Long> {
}
