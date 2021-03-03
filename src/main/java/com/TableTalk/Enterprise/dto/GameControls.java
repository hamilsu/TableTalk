package com.tabletalk.enterprise.dto;

import lombok.Data;

public @Data class GameControls {
    private int min_Players;
    private int max_Players;
    private int min_gameTime;
    private int max_gameTime;
}
