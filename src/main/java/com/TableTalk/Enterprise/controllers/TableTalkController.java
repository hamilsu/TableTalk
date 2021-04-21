package com.TableTalk.Enterprise.controllers;

import com.TableTalk.Enterprise.dto.*;
import com.TableTalk.Enterprise.services.IGameService;
import com.TableTalk.Enterprise.services.IRoomService;
import com.TableTalk.Enterprise.services.IUserService;
import org.apache.tomcat.jni.Local;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



@Controller

public class TableTalkController {

    @Autowired
    IGameService gameService;

    @Autowired
    IRoomService roomService;

    @Autowired
    IUserService userService;


    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Handle the root (/) endpoint and return a start page.
     *
     * @return
     */

    @RequestMapping("/")
    public String index(Model model) {
        return "start";
    }

    /**
     * Handles the Game/ID endpoint.
     *
     * @param id,    game id
     * @param model, page layout.
     * @return "game", webpage template.
     * @throws IOException, bad game ID.
     */
    @GetMapping("/Game/{id}/")
    public String fetchGameById(@PathVariable("id") String id, Model model) throws IOException {
        Game game = gameService.fetchGameById(id);

        StringBuilder strUserRating = new StringBuilder(game.getAverageUserRating().toString());
        strUserRating.setLength(3);
        String averageUserRating = strUserRating.toString();
        game.setAverageUserRating(Double.parseDouble(averageUserRating));

        String newDescription = game.getDescription().replace("<p>","")
                .replace("</p>", "")
                .replace("&quot;", "\"")
                .replace("<br />", "");
        game.setDescription(newDescription);

        model.addAttribute(game);
        return "game";
    }

    @PostMapping(value = "/Game", consumes = "application/json", produces = "application/json")
    public Game createGame(@RequestBody Game game) {
        return game;

    }

    @DeleteMapping("/Game")

    public ResponseEntity deleteGames() {

        return new ResponseEntity(HttpStatus.OK);

    }



    @RequestMapping("/displayRoom/{id}/")
    public String room(Model model, @PathVariable("id") int id) throws IOException {
        List<User> list = new ArrayList<User>();
        User luke = new User();
        ProfilePicture profilePhoto = new ProfilePicture();
        profilePhoto.setPath("/icons/person-circle.svg");
        luke.setDisplayedName("Luke Greeley");

        User storm = new User();
        storm.setDisplayedName("Storm Hamilton");


        User anne = new User();
        anne.setDisplayedName("Anne Catherwood");


        User momadu = new User();
        momadu.setDisplayedName("Momadu Kone");


        list.add(luke);
        list.add(storm);
        list.add(anne);

        Room room = roomService.fetchById(id);

        Game game = gameService.fetchGameById(room.getGameId());
        System.out.println(room.getPhotos());

        List<Photo> photos = new ArrayList<Photo>();
        photos = room.getPhotos();



        model.addAttribute("room", room);
        model.addAttribute("game", game);
        model.addAttribute("photos", photos);

        return "room";
    }


    /**
     * Handles the createRoom endpoint.
     * Currently sets hard-coded data for testing.
     *
     * @param model room layout
     * @return createRoom webpage.
     */
    @RequestMapping("/createRoom")
    public String createRoom(Model model) {
        Room room = new Room();
        room.setGameId("1");
        room.setAddress("101 Main St");
        room.setId(1);

        model.addAttribute(room);
        return "createRoom";
    }

    /**
     * Handles the updateRoom/ID endpoint.
     *
     * @param id,    room id
     * @return "RedirectView", redirects to display room page on success.
     * @throws IOException, bad room ID.
     */

    @GetMapping("/updateRoom/{id}/")
    public String updateRoom(Model model, @PathVariable("id") int id) throws IOException {
        log.debug("Entering update room endpoint");
        Room room = roomService.fetchById(id);
        Game game = gameService.fetchGameById(room.getGameId());
        List<Photo> photos = new ArrayList<Photo>();
        photos = room.getPhotos();
        System.out.println(photos);
        try {
//            roomService.update(room);
            model.addAttribute("room", room);
            model.addAttribute("game", game);
            model.addAttribute("photos", photos);
            System.out.println("I am the room in update id " + room);
//            log.info("Room with ID " + id + " was updated.");
            return "updateRoom";
        } catch (Exception e) {
            log.error("Unable to update room with ID: " + id + ", message: " + e.getMessage(), e);
            return "error";
        }
    }

    @PostMapping("/editRoom/{id}")
    public ModelAndView updateRoom(Room room, @RequestParam("imageFile")MultipartFile imageFile, Model model, @PathVariable("id") int id) throws Exception {
        System.out.println("I am the PHOTOS in updateRoom " + room.photos);
        System.out.println("I am the room in updateRoom " + room);
        Game game = gameService.fetchGameById(room.getGameId());
        System.out.println("I am the game in updateRoom " + game);
        ModelAndView modelAndView = new ModelAndView();

        try {

            if (!imageFile.isEmpty()){
                Photo photo = new Photo();
                try {
                    photo.setFileName(imageFile.getOriginalFilename());
                    photo.setRoom(room);
                    roomService.saveImage(imageFile, photo);
                    photo.setPath("/src/main/upload/" + photo.getFileName());
                    room.photos.add(photo);
                } catch (IOException e) {
                    modelAndView.setViewName("error");
                    return modelAndView;
                }
            }

            roomService.update(room);

            List<Photo> photos = new ArrayList<Photo>();
            photos = room.getPhotos();
            model.addAttribute("room", room);
            model.addAttribute("photos", photos);

            modelAndView.addObject("photos", photos);
            modelAndView.setViewName("room");
        }catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return  modelAndView;
        }



        modelAndView.addObject("game", game);
        modelAndView.addObject("room", room);
        return modelAndView;
    }

    @GetMapping("/room")
    @ResponseBody
    public List<Room> fetchAllRooms() {
        return roomService.fetchAll();
    }

    @GetMapping("/room/{id}/")
    public ResponseEntity fetchRoomById(@PathVariable("id") int id) {
        Room foundRoom = roomService.fetchById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundRoom, headers, HttpStatus.OK);
    }

    @PostMapping(value = "/room", consumes = "application/json", produces = "application/json")
    public Room createRoom(Room room) throws Exception {
        Room newRoom = null;
        roomService.save(room);
        return room;
    }

    /**
     * Populates room from HTML with Thymeleaf.
     * Send DTO to service
     *
     * @param room
     * @return
     * @throws Exception
     */
    @PostMapping("/saveRoom")
    public ModelAndView saveRoom(Room room, @RequestParam("imageFile")MultipartFile imageFile, Model model) throws Exception {
        //todo we shouldn't have to try catch blocks. save everything or save nothing. To do that we have to account for
        // the photo being null
        Game game = gameService.fetchGameById(room.getGameId());
        ModelAndView modelAndView = new ModelAndView();
        try {

            if (!imageFile.isEmpty()){
                Photo photo = new Photo();
                try {
                    photo.setFileName(imageFile.getOriginalFilename());
                    photo.setRoom(room);
                    roomService.saveImage(imageFile, photo);
                    photo.setPath("/src/main/upload/" + photo.getFileName());
                    room.photos.add(photo);
                } catch (IOException e) {
                    modelAndView.setViewName("error");
                    return modelAndView;
                }
            }

            roomService.save(room);

            List<Photo> photos = new ArrayList<Photo>();
            photos = room.getPhotos();
            model.addAttribute("room", room);
            model.addAttribute("photos", photos);

            modelAndView.addObject("photos", photos);
            modelAndView.setViewName("room");
        }catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return  modelAndView;
        }



        modelAndView.addObject("game", game);
        modelAndView.addObject("room", room);
        return modelAndView;
    }



    /**
     * Handles the deleteRoom/ID endpoint.
     *
     * @param id,    room id
     * @return "RedirectView", redirects to display room page on success.
     * @throws IOException, bad room ID.
     */
    @GetMapping("/deleteRoom/{id}/")
    public RedirectView deleteRoom(@PathVariable("id") int id) {
        log.debug("Entering delete room endpoint");
        try {
            roomService.delete(id);
            log.info("Room with ID " + id + " was deleted.");
            return new RedirectView("/");
        } catch (Exception e) {
            log.error("Unable to delete room with ID: " + id + ", message: " + e.getMessage(), e);
            return new RedirectView("error");
        }

    }

    @GetMapping(value = "/getRoomsByUserId/{userId}", produces = "application/json")
    @ResponseBody
    public List<Room> fetchRoomsByUserId(@PathVariable("userId") String id){
        return userService.fetchUser(id).getRooms();

    }



    @PostMapping(value = "/User", consumes = "application/json", produces = "application/json")

    public User createUser(@RequestBody com.TableTalk.Enterprise.dto.User user) {

        return user;

    }

    @DeleteMapping("/User")

    public ResponseEntity deleteUser() {

        return new ResponseEntity(HttpStatus.OK);

    }

    /**
     * Handles the logical searching of games.
     *
     * @param searchTerm, string of what the user is looking for.
     * @return list of games available in auto complete.
     */
    @GetMapping(value="/games", consumes="application/json", produces="application/json")
    public ResponseEntity searchGames(@RequestParam(value = "searchTerm", required = true, defaultValue = "None") String searchTerm) {
        try {
            GameCollection games = gameService.fetchGamesByName(searchTerm);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(games, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Handles the graphical searching of games.
     *
     * @param searchTerm
     * @param model, layout
     * @return games template or error template.
     */
    @GetMapping("/games")
    public String searchGamesForm(@RequestParam(value = "searchTerm", required = true, defaultValue = "None") String searchTerm, Model model) {
        try {
            GameCollection gameList = gameService.fetchGamesByName(searchTerm);
            List<Game> games = gameList.getGames();
            model.addAttribute("games", games);
            return "games";
        } catch (IOException e) {
            e.printStackTrace();
            return "error"; //TODO: Actual error handling
        }

    }

    /*
     * Handles autocomplete of searching games.
     *
     * @param searchTerm
     * @return a list of all the game names.
     */
    @GetMapping("/gameNamesAutocomplete")
    @ResponseBody
    public List<LabelValue> gameNamesAutocomplete(@RequestParam(value = "term", required = false, defaultValue = "default") String searchTerm) {
        List<LabelValue> allGameNames = new ArrayList<LabelValue>();
        try {
            GameCollection games = gameService.fetchGamesByName(searchTerm);
            for (Game game : games.getGames()) {
                LabelValue labelValue = new LabelValue();
                labelValue.setLabel(game.getName());
                labelValue.setValue(game.getId());
                allGameNames.add(labelValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<LabelValue>();
        }
        return allGameNames;
    }


    @RequestMapping ("/login")
    public String login(Model model){
        return "login";
    }
  
    @RequestMapping ("/loginSuccessful/{displayName}/{uid}")
    public String processLogin(@PathVariable("displayName") String displayName, @PathVariable("uid") String uid, Model model){
        User user = new User();
        if(userService.userExistsWithID(uid)){
            user = userService.fetchUser(uid);
        }else{
            user = userService.createUser(uid, displayName);
        }
        model.addAttribute(user);
        return "start";
    }

    @RequestMapping ("/logout")
    public String logout(Model model){
        return "logout";
    }

}