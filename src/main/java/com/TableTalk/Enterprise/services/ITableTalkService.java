package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dto.Game;
import com.TableTalk.Enterprise.dto.Room;
import com.TableTalk.Enterprise.dto.User;

import java.io.IOException;
import java.util.List;

public interface ITableTalkService {

    Room fetchById(String id);

    void deleteRoom(String id) throws Exception;

    Room saveRoom(Room room) throws Exception;

    List<Room> fetchAvailableRooms(User user);

    List<Game> fetchGamesByName(String name) throws IOException;
}
