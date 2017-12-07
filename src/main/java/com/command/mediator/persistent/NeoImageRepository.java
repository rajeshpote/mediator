package com.command.mediator.persistent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.command.mediator.pojo.NeoImageData;

@Repository
public interface NeoImageRepository extends CrudRepository<NeoImageData, Integer>{
	public NeoImageData findByImageName(String name);
}
