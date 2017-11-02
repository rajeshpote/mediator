package com.command.mediator.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.command.mediator.pojo.NeoImageData;

@Repository
public interface NeoImageRepository extends MongoRepository<NeoImageData, String>{

}
