/*package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Room;
import com.TableTalk.Enterprise.dto.User;

import java.util.*;
import java.util.stream.Stream;

public class RoomServiceDAOStub implements IRoomServiceDAO {

    HashMap<String, Room> allRooms = new HashMap<>();


    @Override
    public Room fetch(String id) {

    }

    @Override
    public void delete(String id) throws Exception {

    }

    @Override
    public Room save(Room room) throws Exception {
        String roomID = room.getId();
        allRooms.put(roomID,room);
        return room;
    }

    @Override
    public List<Room> fetchAvailableRooms(String userID) {
        List<Room> availableRooms = new ArrayList<Room>();
        Set<String> roomIDSet = allRooms.keySet();
        Stream<String> roomStream = roomIDSet.stream();
        roomStream.

    }
}

 */
