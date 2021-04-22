package com.TableTalk.Enterprise.services;

import com.TableTalk.Enterprise.dto.User;

public interface IUserService {

    Boolean userExistsWithID(String id);

    User updateUser(User user);


    User fetchUser(String id);

    User createUser(String id, String displayName);
}
