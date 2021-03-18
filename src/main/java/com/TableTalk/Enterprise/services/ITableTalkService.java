package com.TableTalk.Enterprise.services;
<<<<<<< HEAD

import com.TableTalk.Enterprise.dto.Game;
=======
import com.TableTalk.Enterprise.dto.GameCollection;
>>>>>>> master
import com.TableTalk.Enterprise.dto.Room;
import com.TableTalk.Enterprise.dto.User;

import java.io.IOException;
import java.util.List;

public interface ITableTalkService {

<<<<<<< HEAD
    List<Game> fetchGamesByName(String name) throws IOException;
=======
    Room fetchById(String id);

    void deleteRoom(String id) throws Exception;

    Room saveRoom(Room room) throws Exception;

    List<Room> fetchAvailableRooms(User user);

    GameCollection fetchGamesByName(String name) throws IOException;
>>>>>>> master
}