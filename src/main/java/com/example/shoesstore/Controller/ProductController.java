package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.Product;
import com.example.shoesstore.Model.Requests.CreateProductRequest;
import com.example.shoesstore.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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
    @GetMapping("/{proId}")
    ResponseEntity<Product> getProductById(@PathVariable long proId){
        Product product = productService.getProductById(proId);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/{cateId}/category")
    ResponseEntity<List<Product>> getProductByCategory(@PathVariable long cateId){
        List<Product> productList = productService.getProductByCategory(cateId);
        return ResponseEntity.ok(productList);
    }
    @GetMapping("/{braId}/brand")
    ResponseEntity<List<Product>> getProductByBrand(@PathVariable long braId){
        List<Product> productList = productService.getProductByBrand(braId);
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/{cateId}/{braId}")
    ResponseEntity<List<Product>> getProductByCategoryAndBrand(@PathVariable Long cateId,@PathVariable Long braId){
//        List<Product> productList = productService.getProductByCategoryAndBrand(cateId, braId);
//        return ResponseEntity.ok(productList);
        // Kiểm tra xem cateId và braId có được cung cấp không
        if (cateId != null && braId != null) {
            List<Product> products = productService.getProductByCategoryAndBrand(cateId, braId);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else if (cateId != null) {
            // Lấy sản phẩm theo cateId nếu chỉ có cateId được cung cấp
            List<Product> products = productService.getProductByCategory(cateId);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else if (braId != null) {
            // Lấy sản phẩm theo braId nếu chỉ có braId được cung cấp
            List<Product> products = productService.getProductByBrand(braId);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            // Trường hợp không có cateId và braId, có thể xử lý theo nhu cầu
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/date")
    ResponseEntity<List<Product>> getProductByDate(){
        List<Product> productList = productService.getProductByDate();
        return ResponseEntity.ok(productList);
    }
    @GetMapping("/hot")
    ResponseEntity<List<Product>> getProductHot(){
        List<Product> productList = productService.getProductHot();
        return ResponseEntity.ok(productList);
    }
    @GetMapping("/sale")
    ResponseEntity<List<Product>> getProductSale(){
        List<Product> productList = productService.getProductSale();
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
