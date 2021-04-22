package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Photo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Repository
@Profile({"dev", "default"})
public class PhotoSQLDAO implements IPhotoDAO {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PhotoRepository photoRepository;




    @Override
    public void saveImage(MultipartFile imageFile, Photo photo) throws IOException {
        Path currentPath = Paths.get("");
        Path absolutePath = Paths.get(currentPath.toAbsolutePath() + "/src/main/upload/");
        log.info("absolutePath: " + absolutePath);
        if (!Files.exists(absolutePath)){
            Files.createDirectory(absolutePath);
            log.info("Directory (" + absolutePath + ") created");
        }else{
            log.info("Directory (" + absolutePath + ") already exists");
        }

        photo.setPath("/src/main/upload/" + imageFile.getOriginalFilename());
        photoRepository.save(photo);
        photo.setPath(absolutePath + "/" + imageFile.getOriginalFilename());
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(photo.getPath());
        Files.write(path, bytes);

    }
}

