package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dao.IGameDAO;
import com.TableTalk.Enterprise.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceStub implements IGameService {

    @Autowired
    private IGameDAO  gameDAO;

    public GameServiceStub(){

    }

    public GameServiceStub(IGameDAO gameDAO){
        this.gameDAO = gameDAO;
    }


    @Override
    public Game save(Game game) throws Exception {
        return gameDAO.save(game);
    }

    @Override
    public List<Game> fetchAll() {
        return gameDAO.fetchAll();
    }
}
