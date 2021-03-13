package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Room;

import java.util.List;

public interface IRoomServiceDAO {

    Room fetch(Integer id);

    void delete(Integer id) throws Exception;

    Room save(Room room) throws Exception;

    List<Room> fetchAll();

    List<Room> fetchAvailableRooms(String userID);

    void addPlayer(String userID);
}
