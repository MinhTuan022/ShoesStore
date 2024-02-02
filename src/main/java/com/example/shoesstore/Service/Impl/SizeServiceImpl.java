package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.Size;
import com.example.shoesstore.Model.Requests.CreateSizeRequest;
import com.example.shoesstore.Repository.SizeRepository;
import com.example.shoesstore.Service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    SizeRepository sizeRepository;

    @Override
    public List<Size> getAllSize() {
        List<Size> sizeList = sizeRepository.findAll();
        return sizeList;
    }

    @Override
    public Size createSize(CreateSizeRequest request) {
        Size size = new Size();
        size.setSize(request.getSize());
        sizeRepository.save(size);
        return size;
    }

    @Override
    public Size updateSize(Long sId, CreateSizeRequest request) {
        Size size = sizeRepository.findById(sId).orElseThrow();
        size.setSize(request.getSize());
        sizeRepository.save(size);
        return size;
    }

    @Override
    public void deleteSize(Long sId) {
        Size size = sizeRepository.findById(sId).orElseThrow();
        sizeRepository.delete(size);
    }
}
