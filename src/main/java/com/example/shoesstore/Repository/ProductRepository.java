package com.example.shoesstore.Repository;

import com.example.shoesstore.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
