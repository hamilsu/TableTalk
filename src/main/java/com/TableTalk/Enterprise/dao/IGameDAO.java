package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Game;

import java.io.IOException;
import java.util.List;

public interface IGameDAO {

    List<Game> fetchGamesByName(String name) throws IOException;

}
