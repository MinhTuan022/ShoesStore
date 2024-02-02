package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Size;
import com.example.shoesstore.Model.Requests.CreateSizeRequest;

import java.util.List;

public interface SizeService {
    List<Size> getAllSize();
    Size createSize(CreateSizeRequest size);
    Size updateSize(Long sId, CreateSizeRequest size);

    void deleteSize(Long sId);
}
