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
    public List<Game> fetchGamesByName(String name) throws IOException {
        return gameDAO.fetchGamesByName(name);
    }
}