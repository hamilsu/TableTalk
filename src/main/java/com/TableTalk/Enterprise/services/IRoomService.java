package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dto.Photo;
import com.TableTalk.Enterprise.dto.Room;
import com.TableTalk.Enterprise.dto.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Room Service handles business logic for Room DTO.
 */
public interface IRoomService {

    /**
     * Save a new Room
     *
     * @param room the entry to save.
     * @return
     */
    Room save(Room room) throws Exception;

    /**
     * Return all room entries.
     *
     * @return a collection of all room entries.
     */
    List<Room> fetchAll();

    void delete(int id) throws Exception;


    Room fetchById(int id);

    List<Room> fetchUserRooms(User user);

    void saveImage(MultipartFile imageFile, Photo photo) throws IOException;
}


