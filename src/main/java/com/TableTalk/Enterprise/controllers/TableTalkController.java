package com.TableTalk.Enterprise.controllers;

import com.TableTalk.Enterprise.dto.*;
import com.TableTalk.Enterprise.services.IGameService;
import com.TableTalk.Enterprise.services.IRoomService;
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

import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    @RequestMapping("/displayRoom")
    public String room(Model model) {
        List<User> list = new ArrayList<User>();
        User luke = new User();
        ProfilePicture photo = new ProfilePicture();
        photo.setPath("/icons/person-circle.svg");
        luke.setDisplayedName("Luke Greeley");
        luke.setPhoto(photo);

        User storm = new User();
        storm.setDisplayedName("Storm Hamilton");
        storm.setPhoto(photo);

        User anne = new User();
        anne.setDisplayedName("Anne Catherwood");
        anne.setPhoto(photo);

        User momadu = new User();
        momadu.setDisplayedName("Momadu Kone");
        momadu.setPhoto(photo);

        list.add(luke);
        list.add(storm);
        list.add(anne);
        list.add(momadu);

        Room room = new Room();
        room.setId(1);
//        room.setListOfPlayers(list);
        room.setFinalizedDate(LocalDateTime.now());
        room.setAddress("101 Main St. Cincinnati, OH 45219");
        room.setGameId("1");

        Game game = new Game();
        if (room.getGameId() == "1") {
            game.setImageUrl("/uno.jpeg");
        }

        model.addAttribute(room);
        model.addAttribute(game);

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

    /**
     * Handles the availability endpoint.
     * Currently fills with hard-coded data for proof-of-concept
     *
     * @param model, room layout
     * @return availability template.
     */
    @RequestMapping("/availability")
    public String availability(Model model) {
        // testing proof of concept
        Game game = new Game();
        game.setName("UNO");
        game.setId("1");
        model.addAttribute(game);


        return "availability";
    }

    @RequestMapping ("/login")
    public String login(Model model){
        return "login";
    }

    /**
     * Handles autocomplete of searching games.
     *
     * @param searchTerm
     * @return a list of all the game names.
     */
    @GetMapping("/gameNamesAutocomplete")
    @ResponseBody
    public List<LabelValue> gameNamesAutocomplete(@RequestParam(value="term", required = false, defaultValue="default") String searchTerm) {
        List<LabelValue> allGameNames = new ArrayList<LabelValue>();
        try {
            GameCollection games = gameService.fetchGamesByName(searchTerm);
            for (Game game: games.getGames()) {
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

    /**
     * Populates room from HTML with Thymeleaf.
     * Send DTO to service
     *
     * @param room
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveRoom")
    public ModelAndView saveRoom(Room room, @RequestParam("imageFile")MultipartFile imageFile, Model model) throws Exception {
        //todo we shouldn't have to try catch blocks. save everything or save nothing. To do that we have to account for
        // the photo being null
        String returnValue = "createRoom";
        ModelAndView modelAndView = new ModelAndView();
        try {
            roomService.save(room);
        }catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return  modelAndView;
        }

        Photo photo = new Photo();
        try {
            photo.setFilename(imageFile.getOriginalFilename());
            photo.setRoom(room);
            roomService.saveImage(imageFile, photo);
            model.addAttribute("room", room);
            modelAndView.setViewName("success");
        } catch (IOException e){
            modelAndView.setViewName("error");
            return  modelAndView;
        }
        modelAndView.addObject("photo", photo);
        modelAndView.addObject("room", room);
        return modelAndView;
    }
}