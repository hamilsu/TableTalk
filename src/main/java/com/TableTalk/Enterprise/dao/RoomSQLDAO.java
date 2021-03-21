package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roomDAO")
public class RoomSQLDAO implements IRoomDAO {
    @Autowired
    RoomRepository roomRepository;

    @Override
    public Room save(Room room) throws Exception {
        Room createdRoom = roomRepository.save(room);
        return createdRoom;
    }

    @Override
    public List<Room> fetchAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
