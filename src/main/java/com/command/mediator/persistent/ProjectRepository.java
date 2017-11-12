package com.command.mediator.persistent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.command.mediator.pojo.ProjectData;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectData, Integer>{

}
