package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Room;

import java.util.HashMap;
import java.util.List;

public class RoomServiceDAOStub implements IRoomServiceDAO {

    HashMap<String, Room> allRooms = new HashMap<>();


    @Override
    public void fetch(String id) {
        //TODO: Add your function code
    }

    @Override
    public void delete(String id) throws Exception {
        //TODO: Add your function code
    }

    @Override
    public Room save(Room room) throws Exception {
        String roomID = room.getId();
        allRooms.put(roomID, room);
        return room;
    }

    @Override
    public List<Room> fetchAvailableRooms(String userID) {
        return null;
    }

//    @Override
//    public List<Room> fetchAvailableRooms(String userID) {
//        List<Room> availableRooms = new ArrayList<Room>();
//        Set<String> roomIDSet = allRooms.keySet();
//        Stream<String> roomStream = roomIDSet.stream();
//        roomStream.
//
//    }

    @Override
    public void addPlayer(String userID) {
        //TODO: Add your function code
    }
}

