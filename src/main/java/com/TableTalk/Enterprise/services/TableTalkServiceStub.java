package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dao.IGameDAO;
import com.TableTalk.Enterprise.dto.Game;
import com.TableTalk.Enterprise.dto.Room;
import com.TableTalk.Enterprise.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TableTalkServiceStub implements ITableTalkService {

  //  @Autowired
   // private IRoomServiceDAO roomServiceDAO;

    @Autowired
    private IGameDAO gameDAO;

    public TableTalkServiceStub() {

    }

   // public TableTalkServiceStub(IRoomServiceDAO roomServiceDAO){
     //   this.roomServiceDAO = roomServiceDAO;
   // }

    @Override
    public Room fetchById(String id) {
        return null;
    }

    @Override
    public void deleteRoom(String id) throws Exception {

    }

    @Override
    public Room saveRoom(Room room) throws Exception {
        return null;
    }

    @Override
    public List<Room> fetchAvailableRooms(User user) {
        return null;
    }

    @Override
    public List<Game> fetchGamesByName(String name) throws IOException {
        return gameDAO.fetchGamesByName(name);
    }
}