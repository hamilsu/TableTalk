package com.TableTalk.Enterprise.dto;


/*
TODO Check and test this class. This could be wrong considering I'm unfamiliar with firebase.
 */

import lombok.Data;

import java.util.List;

public @Data class User {
    private String displayedName;
    private List<String> gameLibrary; //A list of [game.id]s. TODO Might opt to do a List<Game> instead once we can estimate the load times of each implementation.
    private List<String> availableRooms;

    //The following attributes are assumed as part of firebase and may be redundant to add here. TODO Test for redundancy
    private String username;
    private String password;


    //@OneToMany (mappedBy = "username")
    private ProfilePicture photo; //Might be part of firebase

}
