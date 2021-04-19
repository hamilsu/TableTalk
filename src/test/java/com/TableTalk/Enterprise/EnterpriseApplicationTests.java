package com.TableTalk.Enterprise;

import com.TableTalk.Enterprise.dto.Game;
import com.TableTalk.Enterprise.dto.Room;
import com.TableTalk.Enterprise.services.IGameService;
import com.TableTalk.Enterprise.services.IRoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class EnterpriseApplicationTests {
//
//    @Autowired
//    IGameService gameService;
//
//    @Autowired
//    IRoomService roomService;

    @Test
    void contextLoads(){
    }

    /**
     * Validate that the Game DTO properties can be set and retrieved.
     */
    @Test
    void verifyGameProperties(){
        String url = "www.monopoly.com";
        String name = "Monopoly";
        Integer yearPublished = 1950;

        Game game = new Game();
        game.setUrl(url);
        assertEquals(url, game.getUrl());
        
        game.setName(name);
        assertEquals(name, game.getName());
        
        game.setYearPublished(yearPublished);
        assertEquals(yearPublished, game.getYearPublished() );
    }


//    /**
//     * Validate that the Game DTO properties can be set and retrieved.
//     */
//    @Test
//    void verifyRoomProperties(){
//        String address =  "101 sunshine way";
//
//        Room room = new Room();
//        room.setAddress(address);
//        assertEquals(address, room.getAddress());
//    }
//
//    /**
//     * Validate that the RoomService can save and return Room Entries.
//     */
//    @Test
//    void verifyCreateRoomEntries() throws Exception {
//        String address =  "101 sunshine way";
//
//        Room room = new Room();
//        room.setAddress(address);
//        room.setGameId("heyo");
//
//        System.out.println(room);
//        roomService.save(room);
//
//        List<Room> rooms = roomService.fetchAll();
//        boolean roomPresent = false;
//        for (Room r : rooms) {
//            if (r.getAddress().equals(address)) {
//                roomPresent = true;
//                break;
//            }
//        }
//
//        assertTrue(roomPresent);
//    }
}
