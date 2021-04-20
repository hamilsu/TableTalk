package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dao.IUserDAO;
import com.TableTalk.Enterprise.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;


    @Override
    public Boolean userExistsWithID(String id) {
        return userDAO.userExistsWithID(id);
    }

    @Override
    public User updateUser(User user) {
       return userDAO.updateUser(user);
    }

    @Override
    public User fetchUser(String id) {
        return userDAO.fetchById(id);
    }

    @Override
    public User createUser(String id, String displayName) {
        return userDAO.createUser(id, displayName);
    }
}
