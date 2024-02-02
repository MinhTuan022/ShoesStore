package com.example.shoesstore.Repository;

import com.example.shoesstore.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value ="Select * from orders where u_id = :id",nativeQuery = true)
    List<Order> getOrderByUser(long id);
}
