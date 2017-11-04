package com.command.mediator.persistent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.command.mediator.pojo.NeoProfileData;

@Repository
public interface NeoProfileRepository extends CrudRepository<NeoProfileData, Integer> {

}
