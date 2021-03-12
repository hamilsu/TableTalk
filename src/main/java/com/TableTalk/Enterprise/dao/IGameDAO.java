package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Game;

import java.io.IOException;
import java.util.List;

public interface IGameDAO {
    Game save (Game game) throws Exception;
    List<Game> fetchAll();
    List<Game> fetchGamesByName(String name) throws IOException;
}
