package com.TableTalk.Enterprise.dto;

import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
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

    @Nullable
    @OneToMany(mappedBy = "room")
    private List<Photo> photos;
}