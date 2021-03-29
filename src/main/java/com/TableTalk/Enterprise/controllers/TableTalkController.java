package com.TableTalk.Enterprise.controllers;

import com.TableTalk.Enterprise.dto.Game;
import com.TableTalk.Enterprise.dto.ProfilePicture;
import com.TableTalk.Enterprise.dto.Room;
import com.TableTalk.Enterprise.dto.User;
import com.TableTalk.Enterprise.services.IGameService;
import com.TableTalk.Enterprise.services.IRoomService;
import com.TableTalk.Enterprise.dto.GameCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
public class TableTalkController {

    @Autowired
    IGameService gameService;

    @Autowired
    IRoomService roomService;

    Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * Handle the root (/) endpoint and return a start page.
     *
     * @return
     */

    @RequestMapping("/")
    public String index() {
        return "start";
    }

    @GetMapping("/games")
    public ResponseEntity searchGames(@RequestParam(value="searchTerm", required = true, defaultValue = "None") String searchTerm){
        try{
            GameCollection games = gameService.fetchGamesByName(searchTerm);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(games, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(value="/Game", consumes="application/json", produces="application/json")
    public Game createGame(@RequestBody Game game) {

        return game;

    }

    @DeleteMapping("/Game")

    public ResponseEntity deleteGames() {

        return new ResponseEntity(HttpStatus.OK);

    }


    @GetMapping("/ProfilePicture")

    public ResponseEntity fetchProfilePicture() {

        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping(value="/ProfilePicture", consumes="application/json", produces="application/json")

    public ProfilePicture createProfilePicture(@RequestBody com.TableTalk.Enterprise.dto.ProfilePicture profilePicture) {

        return profilePicture;

    }

    @DeleteMapping("/ProfilePicture")

    public ResponseEntity deleteProfilePicture() {

        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping("/displayRoom")
    public String room(Model model) {
        Room room = new Room();
        room.setGameId(1);
        room.setAddress("101 Main St");
        room.setId(1);

        model.addAttribute(room);
        return "room";
    }

    @GetMapping("/room")
    @ResponseBody
    public List<Room> fetchAllRooms(){
       return roomService.fetchAll();
    }

    @GetMapping("/room/{id}/")
    public ResponseEntity fetchRoomById(@PathVariable("id") int id) {
        Room foundRoom = roomService.fetchById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundRoom, headers, HttpStatus.OK);
    }

    @PostMapping(value="/room", consumes="application/json", produces="application/json")
    public Room createRoom(Room room) throws Exception {
        Room newRoom = null;
        roomService.save(room);
        return room;
    }

    @DeleteMapping("/deleteRoom/{id}/")
    public ResponseEntity deleteRoom(@PathVariable("id") int id) {
        log.debug("Entering delete room endpoint");
        try {
            roomService.delete(id);
            log.info("Room with ID " + id + " was deleted.");
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Unable to delete room with ID: " + id + ", message: " + e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    /**
     * Populates room from HTML with Thymeleaf.
     * Send DTO to service
     * @param room
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveRoom")
    public String saveRoom(Room room) throws Exception {
        try {
            roomService.save(room);
        }catch (Exception e) {
            e.printStackTrace();
            return "createRoom";
        }
        return "createRoom";
    }


    @GetMapping("/User")

    public ResponseEntity fetchUsers() {

        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping(value="/User", consumes="application/json", produces="application/json")

    public User createUser(@RequestBody com.TableTalk.Enterprise.dto.User user) {

        return user;

    }

    @DeleteMapping("/User")

    public ResponseEntity deleteUser() {

        return new ResponseEntity(HttpStatus.OK);

    }


    @RequestMapping("/availability")
    public String availability(Model model) {
        // testing proof of concept
        Game game = new Game();
        game.setName("UNO");
        game.setId("1");
        model.addAttribute(game);


        return "availability";
    }
}

