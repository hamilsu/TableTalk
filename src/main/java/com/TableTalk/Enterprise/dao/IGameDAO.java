package com.tabletalk.Enterprise.dao;

import com.tabletalk.Enterprise.dto.Game;

import java.io.IOException;
import java.util.List;

public interface IGameDAO {
    List<Game> fetchGamesByName(String name) throws IOException;
}
