package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.User;

public interface IUserDAO {
    User fetchById(String id);

    User updateUser(User user);

    Boolean userExistsWithID(String id);

    User createUser(String id, String displayName);
}
