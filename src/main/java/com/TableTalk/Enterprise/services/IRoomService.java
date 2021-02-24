package com.tabletalk.enterprise.services;

import com.tabletalk.enterprise.dto.Game;
import com.tabletalk.enterprise.dto.ProfilePicture;
import com.tabletalk.enterprise.dto.Room;
import com.tabletalk.enterprise.dto.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IRoomService {
    /*

     */

    Room fetchById(String id);

    void deleteRoom(String id) throws Exception;

    Room saveRoom(Room room) throws Exception;

    List<Room> fetchAvailableRooms(User user);
}
