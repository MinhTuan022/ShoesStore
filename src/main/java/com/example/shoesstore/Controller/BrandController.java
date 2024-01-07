package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.Brand;
import com.example.shoesstore.Service.BrandService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/brands")
public class BrandController {
    private BrandService brandService;

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brands = brandService.getAllBrand();
        if (!brands.isEmpty()) {
            return ResponseEntity.ok(brands);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        }
    }
    //    @PostMapping
//    public Brand saveBrand(@RequestBody Brand brand) {
//        return brandService.saveBrand(brand);
//    }
    @PostMapping("/upload-img/{braId}")
    public ResponseEntity<String> uploadBrandImage(@PathVariable Long braId, @RequestParam("file") MultipartFile file) throws IOException {
        Brand brand = brandService.getBrandById(braId);
        if (brand != null && !file.isEmpty()) {
            brand.setBraImage(file.getBytes());
            brandService.saveBrand(brand);
            return ResponseEntity.ok("Image uploaded successfully for brand with ID: " + braId);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to upload image or brand not found.");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Brand> saveBrand(@RequestParam("file") MultipartFile file, @RequestParam("braName") String braName) throws IOException {
        if (!file.isEmpty()) {
            Brand brand = new Brand();
            brand.setBraName(braName);
            brand.setBraImage(file.getBytes());
            Brand savedBrand = brandService.saveBrand(brand);

            if (savedBrand != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(savedBrand);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
