package com.tabletalk.enterprise.dao;

import com.tabletalk.enterprise.dto.Game;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class GameDAO implements IGameDAO{
    @Override
    public List<Game> fetchGamesByName(String name) throws IOException {
        Retrofit retrofitInstance = RetrofitClientInstance.getRetrofitInstance();
        IGameRetrofitDAO gameRetrofitDAO = retrofitInstance.create(IGameRetrofitDAO.class);
        Call<List<Game>> games =  gameRetrofitDAO.getGamesByName(name);
        Response<List<Game>> execute = games.execute();
        List<Game> gameList = execute.body();
        return gameList;
    }
}
