package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.Brand;
import com.example.shoesstore.Entity.Category;
import com.example.shoesstore.Entity.Image;
import com.example.shoesstore.Entity.Product;
import com.example.shoesstore.Exception.ResourceNotFoundException;
import com.example.shoesstore.Model.Requests.CreateProductRequest;
import com.example.shoesstore.Repository.BrandRepository;
import com.example.shoesstore.Repository.CategoryRepository;
import com.example.shoesstore.Repository.ImageRepository;
import com.example.shoesstore.Repository.ProductRepository;
import com.example.shoesstore.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private BrandRepository brandRepository;
    private ImageRepository imageRepository;
    @Override
    public List<Product> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public List<Product> getProductByCategory(long cateId) {
        List<Product> productList = productRepository.getListProductByCategory(cateId);
        return productList;
    }

    @Override
    public List<Product> getProductByBrand(long braId) {
        List<Product> productList = productRepository.getListProductByBrand(braId);
        return productList;
    }

    @Override
    public List<Product> getProductByDate() {
        List<Product> productList = productRepository.getListByDate();
        return productList;
    }

    @Override
    public List<Product> getProductHot() {
        List<Product> productList = productRepository.getListHot();
        return productList;
    }

    @Override
    public List<Product> getProductSale() {
        List<Product> productList = productRepository.getListSale();
        return productList;
    }

    @Override
    public Product createProduct(CreateProductRequest request) {
        Product product = new Product();
        product.setProName(request.getProName());
        product.setProPrice(request.getProPrice());
        product.setProBasisPrice(request.getProBasisPrice());
        product.setProDate(request.getProDate());
        product.setProHot(request.isProHot());
        product.setProState(request.isProState());
        product.setProDescription(request.getProDescription());

        Category category = categoryRepository.findById(request.getCateId())
                .orElseThrow(()-> new ResourceNotFoundException("Not Found Category With Id: " + request.getCateId()));
        product.setCategory(category);

        Brand brand = brandRepository.findById(request.getBraId())
                .orElseThrow(()-> new ResourceNotFoundException("Not Found Brand With Id: " + request.getBraId()));
        product.setBrand(brand);

        Set<Image> images = new HashSet<>();
        for (long imgId: request.getImgId()){
            Image image = imageRepository.findById(imgId).orElseThrow(() -> new ResourceNotFoundException("Not Found Image With Id: " + imgId));
            images.add(image);
        }
        product.setImages(images);

        productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long proId, CreateProductRequest request) {
        Product product = productRepository.findById(proId).orElseThrow(() -> new ResourceNotFoundException("Not Found Product With Id:" + proId));
//        product.setProName(request.getProName());
//        product.setProPrice(request.getProPrice());
//        product.setProBasisPrice(request.getProBasisPrice());
//        product.setProDate(request.getProDate());
//        product.setProHot(request.isProHot());
//        product.setProState(request.isProState());
//        product.setProDescription(request.getProDescription());
//
//        Category category = categoryRepository.findById(request.getCateId())
//                .orElseThrow(()-> new ResourceNotFoundException("Not Found Category With Id: " + request.getCateId()));
//        product.setCategory(category);
//
//        Brand brand = brandRepository.findById(request.getBraId())
//                .orElseThrow(()-> new ResourceNotFoundException("Not Found Brand With Id: " + request.getBraId()));
//        product.setBrand(brand);

        Set<Image> images = new HashSet<>();
        for (long imgId: request.getImgId()){
            Image image = imageRepository.findById(imgId).orElseThrow(() -> new ResourceNotFoundException("Not Found Image With Id: " + imgId));
            images.add(image);
        }
        product.setImages(images);
        productRepository.save(product);
        return product;
    }

    @Override
    public void deleteProduce(Long proId) {
        Product product = productRepository.findById(proId).orElseThrow(() -> new ResourceNotFoundException("Not Found Product With Id:" + proId));
        productRepository.delete(product);
    }


}
