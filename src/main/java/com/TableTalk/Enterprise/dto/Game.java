package com.TableTalk.Enterprise.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import java.util.List;
import java.util.Map;

public @Data class Game {
    @SerializedName("game_id")
    private String id;
    @SerializedName("game_url")
    private String gameUrl;
    @SerializedName("game_name")
    private String gameName;
    @SerializedName("year_published")
    private Integer yearPublished;
    @SerializedName("min_players")
    private Integer minPlayers;
    @SerializedName("max_players")
    private Integer maxPlayers;
    @SerializedName("min_playtime")
    private Integer minPlaytime;
    @SerializedName("max_playtime")
    private Integer maxPlaytime;
    @SerializedName("min_age")
    private Integer minAge;
    @SerializedName("description")
    private String description;
    @SerializedName("thumb_url")
    private String thumbUrl;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("primary_publisher")
    private Map<String,String> primaryPublisher;
    @SerializedName("primary_designer")
    private Map<String,String> primaryDesigner;
    @SerializedName("rules_url")
    private String rulesUrl;
    @SerializedName("official_url")
    private String officialUrl;
    @SerializedName("num_user_ratings")
    private Integer numUserRatings;
    @SerializedName("average_user_rating")
    private Double averageUserRating;
    @SerializedName("tags")
    private List<String> tags = null;
    @SerializedName("description_preview")
    private String descriptionPreview;

}
