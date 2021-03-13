package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Room;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoomDAOStub  implements IRoomDAO {

    Map<Integer, Room> allRoomEntries = new HashMap<Integer, Room>();

    @Override
    public Room save(Room room) throws Exception {
        Integer roomId = room.getId();
        allRoomEntries.put(roomId, room);
        return room;
    }

    @Override
    public List<Room> fetchAll() {
        List<Room> returnRoomEntries = new ArrayList(allRoomEntries.values());
        return returnRoomEntries;
    }

}
