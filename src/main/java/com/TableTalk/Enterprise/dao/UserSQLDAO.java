package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Room;
import com.TableTalk.Enterprise.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;

@Repository
@Profile({"dev", "default"})
public class UserSQLDAO implements IUserDAO {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User fetchById(String id) {
        return userRepository.findById(id).get();
    }

    //Also works as saveUser
    @Override
    public User updateUser(User user) {
           User updatedUser =  userRepository.save(user);
           return updatedUser;

    }

    @Override
    public Boolean userExistsWithID(String id) {
        return userRepository.existsById(id);
    }

    @Override
    public User createUser(String id, String displayName) {
        User newUser = new User();
        newUser.setId(id);
        newUser.setDisplayedName(displayName);
        newUser.setRooms(new ArrayList<Room>());
        return userRepository.save(newUser);

    }
}
