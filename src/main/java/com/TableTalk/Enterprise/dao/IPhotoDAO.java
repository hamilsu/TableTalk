package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPhotoDAO {
    void save(Photo photo);

    void saveImage(MultipartFile imageFile, Photo photo) throws IOException;

}
