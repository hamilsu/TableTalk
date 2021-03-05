package com.tabletalk.enterprise.dto;

import lombok.Data;

public @Data class GameControls {
    private int minPlayers;
    private int maxPlayers;
    private int mingameTime;
    private int maxgameTime;
}
