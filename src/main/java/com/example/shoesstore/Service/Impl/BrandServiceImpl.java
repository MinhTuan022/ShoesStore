package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.Brand;
import com.example.shoesstore.Exception.ResourceNotFoundException;
import com.example.shoesstore.Model.Requests.CreateBrandRequest;
import com.example.shoesstore.Repository.BrandRepository;
import com.example.shoesstore.Service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {
    BrandRepository brandRepository;
    @Override
    public List<Brand> getAllBrand() {
        List<Brand> brandList = brandRepository.findAll();
        return brandList;
    }

    @Override
    public Brand getBrandById(Long braId) {
        Brand brand = brandRepository.findById(braId)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found Brand With Id: " + braId));
        return brand;
    }

//    @Override
//    public Brand createBrand(CreateBrandRequest request, MultipartFile file) throws IOException {
//        Brand brand = new Brand();
//        brand.setBraName(request.getBraName());
//        brand.setBraImage(file.getBytes());
//        return brand;
//    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrandById(Long braId) {
        Brand brand = brandRepository.findById(braId)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found Category With Id: " + braId));
        brandRepository.delete(brand);
    }
}
