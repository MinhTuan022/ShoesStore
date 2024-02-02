package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.Size;
import com.example.shoesstore.Model.Requests.CreateSizeRequest;
import com.example.shoesstore.Service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/size")
public class SizeController {

    @Autowired
    SizeService sizeService;

    @GetMapping
    ResponseEntity<List<Size>> getAllSize(){
        List<Size> sizeList = sizeService.getAllSize();
        return ResponseEntity.ok(sizeList);
    }
    @PostMapping("/create")
    ResponseEntity<Size> createSize(@RequestBody CreateSizeRequest size){
        Size size1 = sizeService.createSize(size);
        return ResponseEntity.ok(size1);
    }

    @PutMapping("/update/{sid}")
    ResponseEntity<Size> updateSize(@PathVariable Long sid, @RequestBody CreateSizeRequest request){
        Size size1 = sizeService.updateSize(sid,request);
        return ResponseEntity.ok(size1);
    }

    @DeleteMapping("{sid}")
    ResponseEntity<String> deleteSize(@PathVariable Long sid){
        sizeService.deleteSize(sid);
        return ResponseEntity.ok("Xóa Thành Công");
    }

}
