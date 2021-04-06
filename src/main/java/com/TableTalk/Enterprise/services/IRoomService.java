package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dto.Room;
import com.TableTalk.Enterprise.dto.User;

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

    /**
     * @param id
     * @throws Exception
     */
    void delete(int id) throws Exception;


    /**
     * @param id
     * @return
     */
    Room fetchById(int id);


    List<Room> fetchUserRooms(User user);
}


