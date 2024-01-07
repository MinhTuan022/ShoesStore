package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Product;
import com.example.shoesstore.Model.Requests.CreateProductRequest;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    Product createProduct(CreateProductRequest request);

    Product updateProduct(Long proId, CreateProductRequest request);

    void deleteProduce(Long proId);

}
