package com.command.mediator.handler;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.persistent.BmServerRepository;
import com.command.mediator.persistent.ProjectRepository;
import com.command.mediator.pojo.ProjectData;
import com.command.mediator.webservice.form.ProjectForm;

@Service
public class ProjectHandler extends BaseHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CobblerHandler.class);
	
	@Resource
	private ProjectRepository projectRepository;
	
	@Resource
	private BmServerRepository bmServerRepository;

	public ProjectData addProject(ProjectForm projectForm) {
		ProjectData projectData = createPojectObject(projectForm);
		projectData = projectRepository.save(projectData);
		LOGGER.info("Project data saved : {} ", projectData);
		return projectData;
	}

	public List<ProjectData> getProjectList() {
		List<ProjectData> projectList = (List<ProjectData>) projectRepository.findAll();
		for (ProjectData projectData : projectList) {
			projectData.setAllocatedBMs(bmServerRepository.countByProjectIdAndStatus(projectData.getId(),"allocated"));
			projectData.setUnallocatedBMs(bmServerRepository.countByProjectIdAndStatus(projectData.getId(),"unallocated"));
		}
		Collections.sort(projectList);
		LOGGER.info("Project List : {} ", projectList);
		return projectList;
	}

}
