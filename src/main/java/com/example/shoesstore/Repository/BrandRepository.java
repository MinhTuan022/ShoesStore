package com.example.shoesstore.Repository;

import com.example.shoesstore.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
