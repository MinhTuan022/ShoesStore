package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Image;
import org.apache.coyote.BadRequestException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    List<Image> getListImage();

    Image getImageById(Long imgId);

    Image save(Image image);

    Image updateImage(Long imgId, MultipartFile file) throws BadRequestException;

    void deleteImage(Long imgId);
}
