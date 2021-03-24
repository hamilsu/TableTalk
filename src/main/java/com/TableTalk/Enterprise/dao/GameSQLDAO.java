package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Game;
import com.TableTalk.Enterprise.dto.GameCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository("gameDAO")
public class GameSQLDAO implements IGameDAO{

    @Autowired
    GameRepository gameRepository;

    @Override
    public Game save(Game game) throws Exception {
        Game createdGame = gameRepository.save(game);
        return createdGame;
    }

    @Override
    public List<Game> fetchAll() {
        return null;
    }

    @Override
    public GameCollection fetchGamesByName(String name) throws IOException {
        return null;
    }
}
