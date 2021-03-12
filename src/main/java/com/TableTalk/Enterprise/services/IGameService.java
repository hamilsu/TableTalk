package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dto.Game;

import java.util.List;

/**
 * Game Service handles business logic for Game DTOs.
 */
public interface IGameService {

    /**
     * Save a new Game
     * @param game the entry to save.
     * @return
     */
    Game save(Game game) throws Exception;

    /**
     * Return all game entries.
     * @return a collection of all game entries.
     */
    List<Game> fetchAll();
}
