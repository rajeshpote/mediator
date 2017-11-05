package com.command.mediator.persistent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.command.mediator.pojo.NeoBmProfileData;

@Repository
public interface NeoBmProfileRepository extends CrudRepository<NeoBmProfileData, Integer>{

	public NeoBmProfileData findByNeoProfileId(Integer profileId);
}
