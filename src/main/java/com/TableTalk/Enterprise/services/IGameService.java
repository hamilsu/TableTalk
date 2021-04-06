package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dto.Game;
import com.TableTalk.Enterprise.dto.GameCollection;

import java.io.IOException;
import java.util.List;

/**
 * Game Service handles business logic for Game DTO.
 */
public interface IGameService {

    /**
     * Save a new Game
     *
     * @param game the entry to save.
     * @return
     */
    Game save(Game game) throws Exception;

    /**
     * Return all game entries.
     *
     * @return a collection of all game entries.
     */
    List<Game> fetchAll();


    /**
     * @param name
     * @return
     * @throws IOException
     */
    GameCollection fetchGamesByName(String name) throws IOException;

    /**
     * @param id
     * @return
     * @throws IOException
     */
    Game fetchGameById(String id) throws IOException;
}
