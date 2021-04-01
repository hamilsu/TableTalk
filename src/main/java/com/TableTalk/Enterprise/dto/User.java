package com.TableTalk.Enterprise.dto;

import lombok.Data;

import java.util.List;

public @Data
class User {
    private String displayedName;
    private List<String> gameLibrary;
    private List<String> availableRooms;

    private String username;
    private String password;

    private ProfilePicture photo;

}
