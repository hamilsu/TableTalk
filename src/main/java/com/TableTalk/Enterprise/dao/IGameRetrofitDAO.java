package com.tabletalk.enterprise.dao;

import com.tabletalk.enterprise.dto.Game;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface IGameRetrofitDAO {

    @GET("https://api.boardgameatlas.com/api/search")
    Call<List<Game>> getGamesByName(@Query("name") String name);

}
