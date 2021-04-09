package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IPhotoDAO {
    void save(Photo photo);

    void saveImage(MultipartFile imageFile) throws IOException;
}
