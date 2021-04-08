package com.TableTalk.Enterprise.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public @Data
class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    private List<User> listOfPlayers;
    private LocalDateTime finalizedDate; //Might opt to change this to a nullable class since initially dates would be tbd
    private String address;
    private String gameId;
}