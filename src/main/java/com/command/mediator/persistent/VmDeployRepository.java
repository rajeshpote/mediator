package com.command.mediator.persistent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.command.mediator.pojo.VmDeployData;

@Repository
public interface VmDeployRepository extends CrudRepository<VmDeployData, Integer>{

}
