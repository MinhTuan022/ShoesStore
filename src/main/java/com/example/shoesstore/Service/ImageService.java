package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Image;

import java.util.List;

public interface ImageService {
    List<Image> getListImage();

    Image getImageById(Long imgId);

    Image save(Image image);

//    List<Image> getListByUser(long userId);

    void deleteImage(Long imgId);
}
