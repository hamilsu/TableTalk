package com.TableTalk.Enterprise.dto;

import lombok.Data;

public @Data
class ProfilePicture {

    private int photoId;
    private String path;
    private String fileName;

    private User user;
}


