package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Room;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
@Profile("test")
public class RoomDAOStub  implements IRoomDAO {

    Map<Integer, Room> allRooms = new HashMap<Integer, Room>();

    @Override
    public Room save(Room room) throws Exception {
        Integer roomId = room.getId();
        allRooms.put(roomId, room);
        return room;
    }

    @Override
    public List<Room> fetchAll() {
        List<Room> returnRooms = new ArrayList(allRooms.values());
        return returnRooms;
    }

    @Override
    public Room fetch(int id) {
        return allRooms.get(id);
    }


    @Override
    public void delete(int id) {
        allRooms.remove(id);
    }

}
