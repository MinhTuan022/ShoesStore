package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.Category;
import com.example.shoesstore.Entity.Image;
import com.example.shoesstore.Exception.ResourceNotFoundException;
import com.example.shoesstore.Repository.ImageRepository;
import com.example.shoesstore.Service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
    ImageRepository imageRepository;
    @Override
    public List<Image> getListImage() {
        List<Image> imageList = imageRepository.findAll();
        return imageList;
    }

    @Override
    public Image getImageById(Long imgId) {
        Image image = imageRepository.findById(imgId).orElseThrow(() -> new ResourceNotFoundException("Image not found width id :" + imgId));
        return image;
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long imgId) {
        Image image = imageRepository.findById(imgId)
                .orElseThrow(()-> new ResourceNotFoundException("Not Found Image With Id: " + imgId));
        imageRepository.delete(image);
    }
}
