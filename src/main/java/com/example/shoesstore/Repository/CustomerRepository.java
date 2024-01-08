package com.example.shoesstore.Repository;

import com.example.shoesstore.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCusUser(String username);
}
