package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Game;
import java.io.IOException;
import java.util.List;

public class DAOGame implements com.TableTalk.Enterprise.dao.IDAOGame {
    public void fetchGameName(String name) throws IOException {
    }

    @Override
    public List<Game> fetchGameNames(String names) throws IOException {
        return null;
    }
}