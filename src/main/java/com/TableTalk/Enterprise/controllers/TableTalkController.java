package com.TableTalk.Enterprise.controllers;

import com.TableTalk.Enterprise.dto.Game;
import com.TableTalk.Enterprise.dto.ProfilePicture;
import com.TableTalk.Enterprise.dto.Room;
import com.TableTalk.Enterprise.dto.User;
import com.TableTalk.Enterprise.services.IRoomService;
import com.TableTalk.Enterprise.services.ITableTalkService;
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
    ITableTalkService TableTalkService;

    @Autowired
    IRoomService roomService;

    /**
     * Handle the root (/) endpoint and return a start page.
     *
     * @return
     */

    @RequestMapping("/")
    public String index() {
        return "start";
    }

    @GetMapping("/Game")

    public ResponseEntity fetchGames() {

        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping(value = "/Game", consumes = "application/json", produces = "application/json")

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

    @PostMapping(value = "/ProfilePicture", consumes = "application/json", produces = "application/json")

    public ProfilePicture createProfilePicture(@RequestBody com.TableTalk.Enterprise.dto.ProfilePicture profilePicture) {

        return profilePicture;

    }

    @DeleteMapping("/ProfilePicture")

    public ResponseEntity deleteProfilePicture() {

        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping("/room")
    public String room(Model model) {
        Room room = new Room();
        room.setGameId(1);
        room.setAddress("101 Main St");
        room.setId(1);

        model.addAttribute(room);
        return "room";
    }

    @RequestMapping("/saveRoom")
    public String saveRoom(Room room) throws Exception {
        Room newRoom = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            newRoom = roomService.save(room);
        }catch (Exception e) {
            e.printStackTrace();
            return "room";
        }
       return "room";
    }

    @GetMapping("/allRooms")
    @ResponseBody
    public List<Room> fetchAllRooms(){
        return roomService.fetchAll();
    }

    @DeleteMapping("/Room")

    public ResponseEntity deleteRoom() {

        return new ResponseEntity(HttpStatus.OK);

    }


    @GetMapping("/User")

    public ResponseEntity fetchUsers() {

        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping(value = "/User", consumes = "application/json", produces = "application/json")

    public User createUser(@RequestBody com.TableTalk.Enterprise.dto.User user) {

        return user;

    }

    @DeleteMapping("/User")

    public ResponseEntity deleteUser() {

        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping("/games")
    public ResponseEntity searchGames(@RequestParam(value = "searchTerm", required = true, defaultValue = "None") String searchTerm) {
        try {
            List<Game> games = TableTalkService.fetchGamesByName(searchTerm);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(games, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping("/availability")
    public String availability(Model model) {
        // testing proof of concept
        Game game = new Game();
        game.setName("UNO");
        game.setId(1);
        model.addAttribute(game);


        return "availability";
    }
}



