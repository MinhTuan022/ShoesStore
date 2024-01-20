package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.Size;
import com.example.shoesstore.Model.Requests.CreateSizeRequest;
import com.example.shoesstore.Repository.SizeRepository;
import com.example.shoesstore.Service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    SizeRepository sizeRepository;
    @Override
    public Size createSize(CreateSizeRequest request) {
        Size size = new Size();
        size.setSize(request.getSize());
        sizeRepository.save(size);
        return size;
    }
}
