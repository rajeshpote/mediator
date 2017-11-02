package com.command.mediator.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.command.mediator.pojo.BMProfileData;

@Repository
public interface BMProfileRepository extends MongoRepository<BMProfileData, String> {

}
