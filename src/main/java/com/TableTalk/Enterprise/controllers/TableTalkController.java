package com.TableTalk.Enterprise.controllers;

import com.TableTalk.Enterprise.services.ITableTalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.TableTalk.Enterprise.dto.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.*;


@Controller
    public class TableTalkController {


    @Autowired
    ITableTalkService TableTalkService;
        /**
         * Handle the root (/) endpoint and return a start page.
         * @return
         */

    @RequestMapping("/")
    public String index() {
        return "start";
    }

    @GetMapping("/Game")

    public ResponseEntity fetchGames(){

        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping(value="/Game", consumes="application/jason", produces="application/json")

    public com.TableTalk.Enterprise.dto.Game createGame(@RequestBody com.TableTalk.Enterprise.dto.Game game){

        return game;

    }

    @DeleteMapping("/Game")

    public ResponseEntity deleteGames(){

        return new ResponseEntity(HttpStatus.OK);

    }



    @GetMapping("/ProfilePicture")

    public ResponseEntity fetchProfilePicture(){

        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping(value="/ProfilePicture", consumes="application/jason", produces="application/json")

    public com.TableTalk.Enterprise.dto.ProfilePicture createProfilePicture(@RequestBody com.TableTalk.Enterprise.dto.ProfilePicture profilePicture){

        return profilePicture;

    }

    @DeleteMapping("/ProfilePicture")

    public ResponseEntity deleteProfilePicture(){

        return new ResponseEntity(HttpStatus.OK);

    }



    @GetMapping("/Room")

    public ResponseEntity fetchRooms(){

        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping(value="/Room", consumes="application/jason", produces="application/json")

    public com.TableTalk.Enterprise.dto.Room createRoom(@RequestBody com.TableTalk.Enterprise.dto.Room room){

        return room;

    }

    @DeleteMapping("/Room")

    public ResponseEntity deleteRoom(){

        return new ResponseEntity(HttpStatus.OK);

    }



    @GetMapping("/User")

    public ResponseEntity fetchUsers(){

        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping(value="/User", consumes="application/jason", produces="application/json")

    public com.TableTalk.Enterprise.dto.User createUser(@RequestBody com.TableTalk.Enterprise.dto.User user){

        return user;

    }

    @DeleteMapping("/User")

    public ResponseEntity deleteUser(){

        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping("/games")
    public ResponseEntity searchGames(@RequestParam(value="searchTerm", required = true, defaultValue = "None") String searchTerm){
        try{
            List<Game> games = TableTalkService.fetchGamesByName(searchTerm);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(games,headers,HttpStatus.OK);
        }
        catch (IOException e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping("/availability")
    public String availability(Model model) {
        // testing proof of concept
        com.TableTalk.Enterprise.dto.Game game = new com.TableTalk.Enterprise.dto.Game();
        game.setGameName("UNO");
        game.setId("1");
        model.addAttribute(game);



        return "availability";
    }
}



