package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Brand;
import com.example.shoesstore.Model.Requests.CreateBrandRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BrandService {
    List<Brand> getAllBrand();
    Brand getBrandById(Long id);

//    Brand createBrand(CreateBrandRequest request, MultipartFile file) throws IOException;

    Brand saveBrand(Brand brand);

    void deleteBrandById(Long id);

}
