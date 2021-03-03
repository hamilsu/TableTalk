package com.tabletalk.enterprise.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/** Main class that controls the collaboration aspects of each game night. 
* Allows for invite links to be generated, the list of games available in the host’s library, 
* and a description of the of game night the host wants to plan. 
* @param gameID the unique identifier for the game that you are a part of
* @return game the game that you will be playing
*/

public @Data class Room {
    private String gameId;
    private List<User> listOfPlayers;
    private LocalDateTime finalizedDate; //Might opt to change this to a nullable class since initially dates would be tbd
    private String address;
    private Game game;
}
