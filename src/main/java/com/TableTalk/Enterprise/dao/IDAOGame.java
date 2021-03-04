package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Game;

import java.io.IOException;
import java.util.List;

public interface IDAOGame {

    List<Game> fetchGameNames(String names) throws IOException;

}
