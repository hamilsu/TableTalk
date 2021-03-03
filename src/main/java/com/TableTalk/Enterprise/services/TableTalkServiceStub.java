package com.tabletalk.enterprise.services;

import com.tabletalk.enterprise.dao.IGameDAO;
import com.tabletalk.enterprise.dao.IRoomServiceDAO;
import com.tabletalk.enterprise.dto.Game;
import com.tabletalk.enterprise.dto.Room;
import com.tabletalk.enterprise.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TableTalkServiceStub implements ITableTalkService {

    @Autowired
    private IRoomServiceDAO roomServiceDAO;

    @Autowired
    private IGameDAO gameDAO;

    public TableTalkServiceStub() {

    }

    public TableTalkServiceStub(IRoomServiceDAO roomServiceDAO){
        this.roomServiceDAO = roomServiceDAO;
    }

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