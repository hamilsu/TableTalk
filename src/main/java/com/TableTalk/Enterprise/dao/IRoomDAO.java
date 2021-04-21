package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Room;

import java.io.IOException;
import java.util.List;

public interface IRoomDAO {
    /**
     * Generate a room
     *
     * @param room
     * @return
     * @throws Exception
     */
    Room save (Room room) throws Exception;

    /**
     * Fetch all rooms
     *
     * @return
     */
    List<Room> fetchAll();

    /**
     * Search for room by ID
     *
     * @param id
     * @return
     */
    Room fetch(int id);

    /**
     * Delete Room
     *
     * @param id
     */
    void delete(int id);

    Room update (Room room) throws Exception;

}
