package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class PhotoDAO implements IPhotoDAO {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public void save(Photo photo){
        photoRepository.save(photo);
    }

    @Override
    public void saveImage(MultipartFile imageFile, Photo photo) throws IOException {
        Path currentPath = Paths.get("");
        Path absolutePath = Paths.get(currentPath.toAbsolutePath() + "/src/main/upload/");
        System.out.println(absolutePath);
        if (!Files.exists(absolutePath)){
            Files.createDirectory(absolutePath);
            //TODO: logging
            System.out.println("Directory created");
        }else{
            //TODO: logging
            System.out.println("Directory already exists");
        }

        photo.setPath(absolutePath + "/" + imageFile.getOriginalFilename());
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(photo.getPath());
        Files.write(path, bytes);

    }
}

