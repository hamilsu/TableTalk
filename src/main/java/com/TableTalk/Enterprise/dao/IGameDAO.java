package com.tabletalk.enterprise.dao;

import com.tabletalk.enterprise.dto.Game;

import java.io.IOException;
import java.util.List;

public interface IGameDAO {
    List<Game> fetchGamesByName(String name) throws IOException;
}
