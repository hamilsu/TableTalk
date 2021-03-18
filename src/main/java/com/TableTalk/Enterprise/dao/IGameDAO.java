package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.GameCollection;

import java.io.IOException;

public interface IGameDAO {
    GameCollection fetchGamesByName(String name) throws IOException;
}
