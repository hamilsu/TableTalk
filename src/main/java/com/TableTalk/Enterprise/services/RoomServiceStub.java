package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dao.IRoomDAO;
import com.TableTalk.Enterprise.dto.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceStub implements IRoomService {
    @Autowired
    private IRoomDAO roomDAO;

    public RoomServiceStub(){

    }

    public RoomServiceStub(IRoomDAO roomDAO){
        this.roomDAO = roomDAO;
    }


    @Override
    public Room save(Room room) throws Exception {
        return roomDAO.save(room);
    }

    @Override
    public List<Room> fetchAll() {
        return roomDAO.fetchAll();
    }
}
