package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, String>{

}
