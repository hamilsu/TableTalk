package com.tabletalk.Enterprise.dao;

import com.tabletalk.Enterprise.dto.Game;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class GameDAO implements IGameDAO{

    private static String CLIENT_ID = "ASOEAibUZS";

    @Override
    public List<Game> fetchGamesByName(String inputtedName) throws IOException {
        Retrofit retrofitInstance = RetrofitClientInstance.getRetrofitInstance();
        IGameRetrofitDAO gameRetrofitDAO = retrofitInstance.create(IGameRetrofitDAO.class);
        Map<String,String> filter = new HashMap<>();
        filter.put("name",inputtedName);
        filter.put("client_id",CLIENT_ID);
        System.out.println(filter);
        Call<List<Game>> games =  gameRetrofitDAO.getGamesByName(filter);
        Response<List<Game>> execute = games.execute();
        List<Game> gameList = execute.body();
        return gameList;
    }
}
