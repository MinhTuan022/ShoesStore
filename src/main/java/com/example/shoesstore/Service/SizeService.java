package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Size;
import com.example.shoesstore.Model.Requests.CreateSizeRequest;

public interface SizeService {
    Size createSize(CreateSizeRequest size);
}
