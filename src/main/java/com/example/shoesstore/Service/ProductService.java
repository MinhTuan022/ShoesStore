package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Product;

import com.example.shoesstore.Model.Requests.CreateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Page<Product> getAllProductByPage(int page, int size);
    Page<Product> getProductByCategory(long cateId, int page, int size);
    Page<Product> getProductByBrand(long braId, int page, int size);
    Page<Product> getProductByCategoryAndBrand(long cateId, long braId, int page, int size);
    List<Product> getProductByDate();
    List<Product> getProductHot();
    List<Product> getProductSale();
    Product getProductById(long proId);
    Product createProduct(CreateProductRequest request);
    Product updateProduct(Long proId, CreateProductRequest request);
    List<Product> searchProduct(String keyword);
    void deleteProduce(Long proId);



}
