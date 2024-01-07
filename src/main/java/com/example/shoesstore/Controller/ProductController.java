package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.Product;
import com.example.shoesstore.Model.Requests.CreateProductRequest;
import com.example.shoesstore.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    ProductService productService;

    @GetMapping
    ResponseEntity<List<Product>> getAllProduct(){
        List<Product> productList = productService.getAllProduct();
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/create")
    ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest request){
        Product product = productService.createProduct(request);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/update/{proId}")
    ResponseEntity<Product> updateProduct(@PathVariable Long proId,@RequestBody CreateProductRequest request){
        Product product = productService.updateProduct(proId, request);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete/{proId}")
    ResponseEntity<String> deleteProduct(@PathVariable Long proId){
        productService.deleteProduce(proId);
        return ResponseEntity.ok("Xóa Thành Công");
    }

}
