package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Game;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

public interface IGameRetrofitDAO {

    @GET("/api/search")
    Call<List<Game>> getGamesByName(@QueryMap Map<String,String> filter);

}
