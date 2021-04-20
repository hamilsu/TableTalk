package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
@Profile("test")
public class UserDAOStub implements IUserDAO{

    Map<String,User> userMap = new HashMap<String,User>();

    @Override
    public User fetchById(String id) {
        return userMap.get(id);
    }

    @Override
    public User updateUser(User user) {
        userMap.remove(user.getId());
        userMap.put(user.getId(),user);
        return  user;
    }

    @Override
    public Boolean userExistsWithID(String id) {
        return userMap.containsKey(id);
    }

    @Override
    public User createUser(String id, String displayName) {
        User newUser = new User();
        newUser.setId(id);
        newUser.setDisplayedName(displayName);
        newUser.setAvailableRooms(new ArrayList<String>());
        userMap.put(newUser.getId(), newUser);
        return newUser;
    }
}
