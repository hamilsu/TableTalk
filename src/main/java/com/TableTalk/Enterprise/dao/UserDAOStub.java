package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.User;

public class UserDAOStub implements IUserDAO{
    @Override
    public User fetchById(String id) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
