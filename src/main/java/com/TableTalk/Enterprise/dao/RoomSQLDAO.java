package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
@Profile({"dev", "default"})
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
        List<Room> allRooms = new ArrayList<>();
        Iterable<Room> rooms = roomRepository.findAll();
        for (Room room : rooms){
            allRooms.add(room);
        }
        return allRooms;
    }

    @Override
    public Room fetch(int id) {
        return  roomRepository.findById(id).get();
    }


    @Override
    public void delete(int id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Room update(Room room) throws Exception {
        Integer roomId = room.getId();
        Room createdRoom = roomRepository.save(room);
        return createdRoom;
    }
}
