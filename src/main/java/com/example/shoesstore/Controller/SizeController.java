package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.Size;
import com.example.shoesstore.Model.Requests.CreateSizeRequest;
import com.example.shoesstore.Service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/size")
public class SizeController {

    @Autowired
    SizeService sizeService;
    @PostMapping("/create")
    ResponseEntity<Size> createSize(@RequestBody CreateSizeRequest size){
        Size size1 = sizeService.createSize(size);
        return ResponseEntity.ok(size1);
    }
}
