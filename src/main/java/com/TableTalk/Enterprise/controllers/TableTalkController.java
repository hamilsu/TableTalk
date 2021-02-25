package com.tabletalk.enterprise.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
    public class TableTalkController {
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
        public com.tabletalk.enterprise.dto.Game createGame(@RequestBody com.tabletalk.enterprise.dto.Game game){
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
        public com.tabletalk.enterprise.dto.ProfilePicture createProfilePicture(@RequestBody com.tabletalk.enterprise.dto.ProfilePicture profilePicture){
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
        public com.tabletalk.enterprise.dto.Room createRoom(@RequestBody com.tabletalk.enterprise.dto.Room room){
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
        public com.tabletalk.enterprise.dto.User createUser(@RequestBody com.tabletalk.enterprise.dto.User user){
            return user;
        }
        @DeleteMapping("/User")
        public ResponseEntity deleteUser(){
        return new ResponseEntity(HttpStatus.OK);
        }

    }



