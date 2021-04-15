package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Game;
import com.TableTalk.Enterprise.dto.GameCollection;

import java.io.IOException;
import java.util.List;

public interface IGameDAO {
    Game save (Game game) throws Exception;
    List<Game> fetchAll();
    GameCollection fetchGamesByName(String name) throws IOException;

    Game fetchGameByID(String id) throws IOException;
}