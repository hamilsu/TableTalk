package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Game;
import com.TableTalk.Enterprise.dto.GameCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class GameDAOStub implements IGameDAO {

    Logger log = LoggerFactory.getLogger(this.getClass());

    final private static String CLIENT_ID = "ASOEAibUZS";

    Map<String, Game> allGameEntries = new HashMap<String, Game>();

    @Override
    public Game save(Game game) throws Exception {
        allGameEntries.put(game.getId(), game);
        return game;
    }

    @Override
    public List<Game> fetchAll() {
        List<Game> returnGameEntries = new ArrayList(allGameEntries.values());
        return returnGameEntries;
    }

    @Override
    public GameCollection fetchGamesByName(String inputtedName) throws IOException {
        Retrofit retrofitInstance = RetrofitClientInstance.getRetrofitInstance();
        IGameRetrofitDAO gameRetrofitDAO = retrofitInstance.create(IGameRetrofitDAO.class);
        Map<String, String> filter = new HashMap<>();
        filter.put("name", inputtedName);
        filter.put("client_id", CLIENT_ID);
        log.info("Filter: " + filter);
        Call<GameCollection> games =  gameRetrofitDAO.getGamesByName(filter);
        Response<GameCollection> execute = games.execute();
        GameCollection gameList = execute.body();
        return gameList;
    }

    @Override
    public Game fetchGameByID(String id) throws IOException {
        Retrofit retrofitInstance = RetrofitClientInstance.getRetrofitInstance();
        IGameRetrofitDAO gameRetrofitDAO = retrofitInstance.create(IGameRetrofitDAO.class);
        Map<String, String> filter = new HashMap<>();
        filter.put("ids", id);
        filter.put("client_id", CLIENT_ID);
        log.info("Filter: " + filter);
        Call<GameCollection> games =  gameRetrofitDAO.getGamesByName(filter);
        Response<GameCollection> execute = games.execute();
        GameCollection gameList = execute.body();
        Game game = gameList.getGames().remove(0);
        return game;
    }

}
