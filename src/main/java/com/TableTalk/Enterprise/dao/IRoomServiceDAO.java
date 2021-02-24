package com.tabletalk.enterprise.dao;

import com.tabletalk.enterprise.dto.Room;
import com.tabletalk.enterprise.dto.User;

import java.util.List;

public interface IRoomServiceDAO {

    Room fetch(String id);

    void delete(String id) throws Exception;

    Room save(Room room) throws Exception;

    List<Room> fetchAvailableRooms(String userID);

    void addPlayer(String userID);
}
