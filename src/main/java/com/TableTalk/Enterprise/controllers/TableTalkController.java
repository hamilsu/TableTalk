package com.TableTalk.Enterprise.controllers;

import com.TableTalk.Enterprise.dto.*;
import com.TableTalk.Enterprise.services.IGameService;
import com.TableTalk.Enterprise.services.IRoomService;
import com.TableTalk.Enterprise.services.IUserService;
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
        log.debug("Entering index method");
        return "start";
    }

    /**
     * Handles the fetch game by id endpoint.
     *
     * @param id,    game id
     * @param model, page layout.
     * @return "game", webpage template.
     * @throws IOException, bad game ID.
     */
    @GetMapping("/Game/{id}/")
    public String fetchGameById(@PathVariable("id") String id, Model model) throws IOException {
        log.debug("Entering fetch game endpoint");
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
        log.debug("Entering create game endpoint");
        return game;

    }

    @DeleteMapping("/Game")

    public ResponseEntity deleteGames() {
        log.debug("Entering delete game endpoint");
        return new ResponseEntity(HttpStatus.OK);

    }


    /**
     * Handles the displayRoom/ID endpoint.
     *
     * @param id,    game id
     * @param model, page layout.
     * @return "room", webpage template.
     * @throws IOException, bad room ID.
     */
    @RequestMapping("/displayRoom/{id}/")
    public String room(Model model, @PathVariable("id") int id) throws IOException {
        List<User> list = new ArrayList<User>();
        User luke = new User();
        ProfilePicture profilePhoto = new ProfilePicture();
        profilePhoto.setPath("/icons/person-circle.svg");

        Room room = roomService.fetchById(id);

        Game game = gameService.fetchGameById(room.getGameId());

        List<Photo> photos = new ArrayList<Photo>();
        photos = room.getPhotos();

        model.addAttribute("room", room);
        model.addAttribute("game", game);
        model.addAttribute("photos", photos);

        return "room";
    }


    /**
     * Handles the createRoom endpoint.
     *
     * @param model room layout
     * @return createRoom webpage.
     */
    @RequestMapping("/createRoom/{gameId}")
    public String createRoom(@PathVariable("gameId") String gameId, Model model)throws IOException {
        Game game = gameService.fetchGameById(gameId);
        Room room = new Room();
        room.setGameId(gameId);
        room.setAddress("");
        room.setId(1);

        model.addAttribute(game);
        model.addAttribute(room);
        return "createRoom";
    }

    /**
     * Handles the updateRoom/ID endpoint.
     *
     * @param id, room id
     * @param model room layout
     * @return modelAndView
     * @throws IOException, bad room ID.
     */

    @GetMapping("/updateRoom/{id}/")
    public String updateRoom(Model model, @PathVariable("id") int id) throws IOException {
        log.debug("Entering update room endpoint");
        Room room = roomService.fetchById(id);
        Game game = gameService.fetchGameById(room.getGameId());
        List<Photo> photos = new ArrayList<Photo>();
        photos = room.getPhotos();
        try {
            roomService.update(room);
            model.addAttribute("room", room);
            model.addAttribute("game", game);
            model.addAttribute("photos", photos);
            log.info("Room with ID " + id + " was updated.");
            return "updateRoom";
        } catch (Exception e) {
            log.error("Unable to update room with ID: " + id + ", message: " + e.getMessage(), e);
            return "error";
        }
    }

    /**
     * Handles the update endpoint.
     *
     * @param model room layout
     * @return room webpage.
     * @throws IOException, bad room ID.
     */

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
        log.debug("Entering fetch room endpoint");
        Room foundRoom = roomService.fetchById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundRoom, headers, HttpStatus.OK);
    }

    @PostMapping(value = "/room", consumes = "application/json", produces = "application/json")
    public Room createRoom(Room room) throws Exception {
        log.debug("Entering save room endpoint");
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
        try{
            roomService.save(room);
        }catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return  modelAndView;
        }
        Photo photo = new Photo();
        try {
            if (!imageFile.isEmpty()) {
                photo.setFileName(imageFile.getOriginalFilename());
                photo.setRoom(room);
                roomService.saveImage(imageFile, photo);
                List<Photo> photos = room.getPhotos();
                model.addAttribute("room", room);
                model.addAttribute("photos", photos);
                modelAndView.setViewName("room");
            }
        } catch (IOException e){
            modelAndView.setViewName("error");
            return  modelAndView;
        }
        modelAndView.addObject("game", game);
        modelAndView.addObject("photos", photo);
        modelAndView.addObject("room", room);
        modelAndView.setViewName("room");
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



    /**
     * Handles the logical searching of games.
     *
     * @param searchTerm, string of what the user is looking for.
     * @return list of games available in auto complete.
     */
    @GetMapping(value="/games", consumes="application/json", produces="application/json")
    public ResponseEntity searchGames(@RequestParam(value = "searchTerm", required = true, defaultValue = "None") String searchTerm) {
        log.debug("Entering search games endpoint");
        try {
            GameCollection games = gameService.fetchGamesByName(searchTerm);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            log.info("Game with searchTerm " + searchTerm + " was found.");
            return new ResponseEntity(games, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Unable to find game with searchTerm: " + searchTerm + ", message: " + e.getMessage(), e);
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
        log.debug("Entering search games endpoint");
        try {
            GameCollection gameList = gameService.fetchGamesByName(searchTerm);
            List<Game> games = gameList.getGames();
            model.addAttribute("games", games);
            log.info("list of games found: " + games);
            return "games";
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Unable to show games, message: " + e.getMessage(), e);
            return "error"; //TODO: Actual error handling
        }

    }

    /**
     * Handles autocomplete of searching games.
     *
     * @param searchTerm
     * @return a list of all the game names.
     * @throws IOException
     */
    @GetMapping("/gameNamesAutocomplete")
    @ResponseBody
    public List<LabelValue> gameNamesAutocomplete(@RequestParam(value = "term", required = false, defaultValue = "default") String searchTerm) {
        log.debug("Entering autocomplete method");
        List<LabelValue> allGameNames = new ArrayList<LabelValue>();
        try {
            GameCollection games = gameService.fetchGamesByName(searchTerm);
            for (Game game : games.getGames()) {
                LabelValue labelValue = new LabelValue();
                labelValue.setLabel(game.getName());
                labelValue.setValue(game.getId());
                allGameNames.add(labelValue);
            }
            log.info("autocomplete success for searchTerm: " + searchTerm);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("autocomplete failure for searchTerm: " + searchTerm + ", message: " + e.getMessage(), e);
            return new ArrayList<LabelValue>();
        }
        return allGameNames;
    }

    /**
     * Handles logging in.
     *
     * @param model , web template
     * @return "login", login webpage.
     */
    @RequestMapping ("/login")
    public String login(Model model){
        return "login";
    }



    /**
     * Process logging into application.
     *
     * @param displayName
     * @param uid , userId
     * @param model , web template
     * @return "start", start webpage.
     */
    @RequestMapping ("/loginSuccessful/{displayName}/{uid}")
    public RedirectView processLogin(@PathVariable("displayName") String displayName, @PathVariable("uid") String uid, Model model){
        User user = new User();
        if(userService.userExistsWithID(uid)){
            user = userService.fetchUser(uid);
        }else{
            user = userService.createUser(uid, displayName);
        }
        model.addAttribute(user);
        return new RedirectView("/");
    }

    @RequestMapping ("/logout")
    public String logout(Model model){
        return "logout";
    }

}