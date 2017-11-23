package com.command.mediator.persistent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.command.mediator.pojo.BmServerData;

@Repository
public interface BmServerRepository extends CrudRepository<BmServerData, Integer>{

	public long countByProjectIdAndStatus(Integer profileId,String status);
	public BmServerData findByName(String name);

}
