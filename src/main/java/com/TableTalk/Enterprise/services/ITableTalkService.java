package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dto.Game;
import com.TableTalk.Enterprise.dto.Room;
import com.TableTalk.Enterprise.dto.User;

import java.io.IOException;
import java.util.List;

public interface ITableTalkService {

    List<Game> fetchGamesByName(String name) throws IOException;
}