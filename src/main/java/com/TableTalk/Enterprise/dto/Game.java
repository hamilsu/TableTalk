package com.tabletalk.enterprise.dto;

//This class might be unnecessary as it's essentially just a refined version of what we get from the BoardGameAtlas (BGA) API. We could probably just cut most of the information out on our end and make it link to the BGA page.

import lombok.Data;

public @Data class Game {
    private String gameId;
    private String url;
    private String gameName;
    private String thumb_url;
    private String picture_url;
    private String description;
}
