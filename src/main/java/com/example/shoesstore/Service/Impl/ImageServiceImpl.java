package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.Category;
import com.example.shoesstore.Entity.Image;
import com.example.shoesstore.Exception.InternalServerException;
import com.example.shoesstore.Exception.ResourceNotFoundException;
import com.example.shoesstore.Repository.ImageRepository;
import com.example.shoesstore.Service.ImageService;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public Image updateImage(Long imgId, MultipartFile file) throws BadRequestException {
        String originalFileName = file.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.indexOf(".") +1);;
        if(originalFileName != null && originalFileName.length() > 0){
            if(!extension.equals("png") && !extension.equals("jpg") && !extension.equals("gif")){
                throw new BadRequestException("Không hỗ trợ định dạng này");
            }
            try{
                Image image = imageRepository.findById(imgId).orElseThrow();
                image.setImgName(file.getOriginalFilename());
                image.setImgType(extension);
                image.setImgSize(file.getSize());
                image.setImgData(file.getBytes());
                imageRepository.save(image);
                return image;

            } catch (Exception e) {
                throw new InternalServerException("Lỗi khi upload file");
            }
        }
        throw new BadRequestException("File không hợp lệ");
    }

    @Override
    public void deleteImage(Long imgId) {
        Image image = imageRepository.findById(imgId)
                .orElseThrow(()-> new ResourceNotFoundException("Not Found Image With Id: " + imgId));
        imageRepository.delete(image);
    }
}
