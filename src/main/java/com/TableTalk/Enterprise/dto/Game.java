package com.TableTalk.Enterprise.dto;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

@Entity
public @Data
class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @SerializedName("id")
    private String id;
    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;
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
    private Map<String, String> primaryPublisher;
    @SerializedName("primary_designer")
    private Map<String, String> primaryDesigner;
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
