package com.example.shoesstore.Repository;

import com.example.shoesstore.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("Select c from Category c where c.cateState = true")
    List<Category> findALLByEnabled();
}
