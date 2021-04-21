package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Game;
import com.TableTalk.Enterprise.dto.GameCollection;

import java.io.IOException;
import java.util.List;

public interface IGameDAO {
    /**
     * Generates a game
     *
     * @param game
     * @return
     * @throws Exception
     */
    Game save (Game game) throws Exception;

    /**
     * @return
     */
    List<Game> fetchAll();

    /**
     * Searches for game by Name
     *
     * @param name
     * @return
     * @throws IOException
     */
    GameCollection fetchGamesByName(String name) throws IOException;

    /**
     * Search for game by ID
     *
     * @param id
     * @return
     * @throws IOException
     */
    Game fetchGameByID(String id) throws IOException;

}
