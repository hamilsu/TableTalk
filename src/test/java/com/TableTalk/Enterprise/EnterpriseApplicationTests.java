package com.TableTalk.Enterprise;

import com.TableTalk.Enterprise.dto.Game;
import com.TableTalk.Enterprise.services.IGameService;
import com.TableTalk.Enterprise.services.ITableTalkService;
import com.google.gson.annotations.SerializedName;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class EnterpriseApplicationTests {

    @Autowired
    IGameService gameService;

    @Test
    void contextLoads(){
    }

    /**
     * Validate that the Game DTO properties can be set and retrieved.
     */
    @Test
    void verifyGameProperties(){
        String url = "www.monopoly.com";
        String name = "Monopoly";
        Integer yearPublished = 1950;
        Integer minPlayers = 2;
        Integer maxPlayers = 8;
        Integer minPlaytime = 10;
        Integer maxPlaytime = 60;
        Integer minAge = 12;
        String description = "a fun game";
        String thumbUrl = "monopoly.com";
        String imageUrl = "www.someimage.com";
        Map<String, String> primaryPublisher = new HashMap<String, String>();
        primaryPublisher.put("John", "Doe");
        Map<String, String> primaryDesigner = new HashMap<String, String>();
        primaryDesigner.put("Jane", "Smith");
        String rulesUrl = "www.rules.com";
        String officialUrl = "www.official.com";
        Integer numUserRatings =10;
        Double averageUserRating = 8.0;
        List<String> tags = new ArrayList<String>();
        tags.add("tag1");
        tags.add("tag2");
        String descriptionPreview = "a very fun, long game";

        Game game = new Game();
        game.setUrl(url);
        assertEquals(url, game.getUrl());
        
        game.setName(name);
        assertEquals(name, game.getName());
    }

    /**
     * Validate that the TableTalkService can save and return Game Entries.
     */
    @Test
    void verifyAddAndRemoveGameEntries() throws Exception {
        String name =  "Monopoly";
        String url = "www.monopoly.com";

        Game game = new Game();
        game.setName(name);
        game.setUrl(url);

        System.out.println(game);
        gameService.save(game);

        List<Game> games = gameService.fetchAll();
        boolean gamePresent = false;
        for (Game g : games) {
            if (g.getName().equals(name) && g.getUrl().equals(url)) {
                gamePresent = true;
                break;
            }
        }

        assertTrue(gamePresent);


    }
}
