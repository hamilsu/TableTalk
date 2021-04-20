package com.TableTalk.Enterprise.dao;

import com.TableTalk.Enterprise.dto.Photo;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("!test")
public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
