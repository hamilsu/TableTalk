package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Room;

import java.util.List;

public interface IRoomServiceDAO {

    void fetch(String id);

    void delete(String id) throws Exception;

    Room save(Room room) throws Exception;

    List<Room> fetchAvailableRooms(String userID);

    void addPlayer(String userID);
}
