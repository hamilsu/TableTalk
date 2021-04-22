package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IPhotoDAO {


    void saveImage(MultipartFile imageFile, Photo photo) throws IOException;

}
