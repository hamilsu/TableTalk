package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Room;

import java.io.IOException;
import java.util.List;

public interface IRoomDAO {
    Room save (Room room) throws Exception;

    List<Room> fetchAll();

    Room fetch(int id);

    void delete(int id);

    Room update (Room room) throws Exception;

}
