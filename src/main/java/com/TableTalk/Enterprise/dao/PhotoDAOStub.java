package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Photo;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Repository
@Profile("test")
public class PhotoDAOStub implements IPhotoDAO{

    Map<String,Photo> allPhotos = new HashMap<String, Photo>();
    Map<String,MultipartFile> allImages = new HashMap<String,MultipartFile>();


    @Override
    public void saveImage(MultipartFile imageFile, Photo photo) throws IOException {
                allImages.put(photo.getFileName(), imageFile);
    }
}
