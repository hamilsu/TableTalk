package com.tabletalk.enterprise.dto;

//This class might be unnecessary as it's essentially just a refined version of what we get from the BoardGameAtlas (BGA) API. We could probably just cut most of the information out on our end and make it link to the BGA page.

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class Game {
    @SerializedName("id")
    private String id;
    @SerializedName("handle")
    private String handle;
    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private String price;
    @SerializedName("price_ca")
    private String priceCa;
    @SerializedName("price_uk")
    private String priceUk;
    @SerializedName("price_au")
    private String priceAu;
    @SerializedName("msrp")
    private Integer msrp;
    @SerializedName("msrps")
    private List<Msrp> msrps = null;
    @SerializedName("discount")
    private String discount;
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
    @SerializedName("commentary")
    private String commentary;
    @SerializedName("faq")
    private String faq;
    @SerializedName("thumb_url")
    private String thumbUrl;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("matches_specs")
    private Object matchesSpecs;
    @SerializedName("specs")
    private List<Object> specs = null;
    @SerializedName("mechanics")
    private List<Mechanic> mechanics = null;
    @SerializedName("categories")
    private List<Category> categories = null;
    @SerializedName("publishers")
    private List<Publisher> publishers = null;
    @SerializedName("designers")
    private List<Designer> designers = null;
    @SerializedName("primary_publisher")
    private PrimaryPublisher primaryPublisher;
    @SerializedName("primary_designer")
    private PrimaryDesigner primaryDesigner;
    @SerializedName("developers")
    private List<Object> developers = null;
    @SerializedName("related_to")
    private List<Object> relatedTo = null;
    @SerializedName("artists")
    private List<String> artists = null;
    @SerializedName("names")
    private List<Object> names = null;
    @SerializedName("rules_url")
    private String rulesUrl;
    @SerializedName("amazon_rank")
    private Integer amazonRank;
    @SerializedName("official_url")
    private String officialUrl;
    @SerializedName("comment_count")
    private Integer commentCount;
    @SerializedName("num_user_ratings")
    private Integer numUserRatings;
    @SerializedName("average_user_rating")
    private Double averageUserRating;
    @SerializedName("weight_amount")
    private Integer weightAmount;
    @SerializedName("weight_units")
    private String weightUnits;
    @SerializedName("size_height")
    private Integer sizeHeight;
    @SerializedName("size_depth")
    private Integer sizeDepth;
    @SerializedName("size_units")
    private String sizeUnits;
    @SerializedName("historical_low_prices")
    private List<HistoricalLowPrice> historicalLowPrices = null;
    @SerializedName("active")
    private Boolean active;
    @SerializedName("bgg_id")
    private Integer bggId;
    @SerializedName("num_user_complexity_votes")
    private Integer numUserComplexityVotes;
    @SerializedName("average_learning_complexity")
    private Double averageLearningComplexity;
    @SerializedName("average_strategy_complexity")
    private Double averageStrategyComplexity;
    @SerializedName("visits")
    private Integer visits;
    @SerializedName("lists")
    private Integer lists;
    @SerializedName("mentions")
    private Integer mentions;
    @SerializedName("links")
    private Integer links;
    @SerializedName("plays")
    private Integer plays;
    @SerializedName("rank")
    private Integer rank;
    @SerializedName("type")
    private String type;
    @SerializedName("trending_rank")
    private Integer trendingRank;
    @SerializedName("listing_clicks")
    private Integer listingClicks;
    @SerializedName("is_historical_low")
    private Boolean isHistoricalLow;
    @SerializedName("msrp_text")
    private String msrpText;
    @SerializedName("price_text")
    private String priceText;
    @SerializedName("tags")
    private List<String> tags = null;
    @SerializedName("images")
    private Images__ images;
    @SerializedName("description_preview")
    private String descriptionPreview;
