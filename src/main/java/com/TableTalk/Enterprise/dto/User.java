package com.TableTalk.Enterprise.dto;



import lombok.Data;

import java.util.List;

public @Data
class User {
    private String id;
    private String displayedName;
    private List<String> availableRooms;


}
