package com.tabletalk.Enterprise.services;

import com.tabletalk.Enterprise.dto.Game;
import com.tabletalk.Enterprise.dto.Room;
import com.tabletalk.Enterprise.dto.User;

import java.io.IOException;
import java.util.List;

public interface ITableTalkService {

    Room fetchById(String id);

    void deleteRoom(String id) throws Exception;

    Room saveRoom(Room room) throws Exception;

    List<Room> fetchAvailableRooms(User user);

    List<Game> fetchGamesByName(String name) throws IOException;
}
