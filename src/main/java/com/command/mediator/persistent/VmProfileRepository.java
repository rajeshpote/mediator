package com.command.mediator.persistent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.command.mediator.pojo.VmProfileData;

@Repository
public interface VmProfileRepository extends CrudRepository<VmProfileData, Integer>{

}
