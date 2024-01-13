package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Product;
import com.example.shoesstore.Model.Requests.CreateProductRequest;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    List<Product> getProductByCategory(long cateId);

    List<Product> getProductByBrand(long braId);
    List<Product> getProductByCategoryAndBrand(long cateId, long braId);

    List<Product> getProductByDate();

    List<Product> getProductHot();
    List<Product> getProductSale();

    Product getProductById(long proId);
    Product createProduct(CreateProductRequest request);

    Product updateProduct(Long proId, CreateProductRequest request);

    void deleteProduce(Long proId);

}
