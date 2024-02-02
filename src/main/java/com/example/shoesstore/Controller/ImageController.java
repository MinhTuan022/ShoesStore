package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.Image;
import com.example.shoesstore.Exception.InternalServerException;
import com.example.shoesstore.Service.ImageService;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/images")
public class ImageController {
    private static String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/photos/";
    ImageService imageService;

    @GetMapping
    ResponseEntity<List<Image>> getAllImage(){
        List<Image> imageList = imageService.getListImage();
        return ResponseEntity.ok(imageList);
    }

    @PostMapping("/uploadImage")
    ResponseEntity<Image> uploadFile(@RequestParam("file") MultipartFile file) throws BadRequestException {
        File uploadDir = new File(UPLOAD_DIR);
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }

        String originalFileName = file.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.indexOf(".") +1);;
        if(originalFileName != null && originalFileName.length() > 0){
            if(!extension.equals("png") && !extension.equals("jpg") && !extension.equals("gif")){
                throw new BadRequestException("Không hỗ trợ định dạng này");
            }
            try{
                Image image = new Image();
                image.setImgName(file.getOriginalFilename());
                image.setImgType(extension);
                image.setImgSize(file.getSize());
                image.setImgData(file.getBytes());
                //create file
//                String uid = UUID.randomUUID().toString();
//                String link = UPLOAD_DIR + uid + "." + extension;
//                File serverFile = new File(link);
//                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//                stream.write(file.getBytes());
//                stream.close();

                imageService.save(image);
                return ResponseEntity.ok(image);

            } catch (Exception e) {
                throw new InternalServerException("Lỗi khi upload file");
            }
        }
        throw new BadRequestException("File không hợp lệ");
    }
    @PutMapping("/update/{imgId}")
    ResponseEntity<Image> updateImage(@PathVariable Long imgId, @RequestParam("file") MultipartFile file) throws BadRequestException {
        Image image =imageService.updateImage(imgId, file);
        return ResponseEntity.ok(image);
    }

    @DeleteMapping("/delete/{imgId}")
    ResponseEntity<String> deleteImage(@PathVariable Long imgId){
        imageService.deleteImage(imgId);
        return ResponseEntity.ok("Xóa Thành Công");
    }
}
