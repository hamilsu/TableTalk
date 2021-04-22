package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("!test")
public interface UserRepository extends CrudRepository<User, String> {
}
