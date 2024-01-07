package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.Category;
import com.example.shoesstore.Model.Requests.CreateCategoryRequest;
import com.example.shoesstore.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoryList = categoryService.getListEnabled();
        return ResponseEntity.ok(categoryList);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CreateCategoryRequest request){
        Category category = categoryService.createCategory(request);
        return ResponseEntity.ok(category);

    }

    @PutMapping("/update/{cateId}")
    public ResponseEntity<Category> updateCategory(@PathVariable("cateId") Long cateId,@Valid @RequestBody CreateCategoryRequest request){
        Category category = categoryService.updateCategory(cateId, request);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/delete/{cateId}")
    public ResponseEntity<String> deleteCategory(@PathVariable("cateId") Long cateId){
        categoryService.deleteCategory(cateId);
        return ResponseEntity.ok("Xóa Thành Công");
    }
}
