package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Room;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoomDAOStub  implements IRoomDAO {

    Map<String, Room> allRoomEntries = new HashMap<String, Room>();

    @Override
    public Room save(Room room) throws Exception {
        allRoomEntries.put(room.getId(), room);
        return room;
    }

    @Override
    public List<Room> fetchAll() {
        List<Room> returnRoomEntries = new ArrayList(allRoomEntries.values());
        return returnRoomEntries;
    }

}
