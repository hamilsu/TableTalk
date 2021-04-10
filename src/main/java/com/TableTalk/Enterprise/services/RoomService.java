package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dao.IPhotoDAO;
import com.TableTalk.Enterprise.dao.IRoomDAO;
import com.TableTalk.Enterprise.dto.Photo;
import com.TableTalk.Enterprise.dto.Room;
import com.TableTalk.Enterprise.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private IRoomDAO roomDAO;

    @Autowired
    private IPhotoDAO photoDAO;

    public RoomService(){

    }

    public RoomService(IRoomDAO roomDAO){
        this.roomDAO = roomDAO;
    }


    @Override
    public Room save(Room room) throws Exception {
        return roomDAO.save(room);
    }

    @Override
    public List<Room> fetchAll() {
        return roomDAO.fetchAll();
    }


    @Override
    public void delete(int id) throws Exception {
        roomDAO.delete(id);
    }

    @Override
    public Room fetchById(int id) {
        Room foundRoom = roomDAO.fetch(id);
        return foundRoom;
    }

    @Override
    public List<Room> fetchUserRooms(User user) {
        return null;
    }

    @Override
    public void saveImage(MultipartFile imageFile, Photo photo) throws IOException {
        photoDAO.save(photo);
        photoDAO.saveImage(imageFile, photo);
    }

}
