package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.GameCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface IGameRetrofitDAO {

    @GET("/api/search")
    Call<GameCollection> getGamesByName(@QueryMap Map<String,String> filter);

    @GET("/api/search")
    Call<GameCollection> getGameById(@QueryMap Map<String,String> filter);
}
