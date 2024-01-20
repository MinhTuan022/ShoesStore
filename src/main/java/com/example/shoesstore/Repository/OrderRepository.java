package com.example.shoesstore.Repository;

import com.example.shoesstore.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
