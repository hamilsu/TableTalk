package com.TableTalk.Enterprise.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

public @Data class GameCollection {
    @SerializedName("games")
    private List<Game> games;

}
