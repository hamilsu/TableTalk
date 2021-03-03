package com.tabletalk.enterprise.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

public @Data class Room {
    private String gameId;
    private List<User> listOfPlayers;
    private LocalDateTime finalizedDate; //Might opt to change this to a nullable class since initially dates would be tbd
    private String address;
    private Game game;
}
