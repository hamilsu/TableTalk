package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dto.Room;

import java.util.List;

/**
 * Room Service handles business logic for Room DTO.
 */
public interface IRoomService {

    /**
     * Save a new Room
     *
     * @param room the entry to save.
     * @return
     */
    Room save(Room room) throws Exception;

    /**
     * Return all room entries.
     *
     * @return a collection of all room entries.
     */
    List<Room> fetchAll();
}
