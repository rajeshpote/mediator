package com.command.mediator.webservice.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.command.mediator.handler.ProjectHandler;
import com.command.mediator.model.MediatorResponseModel;
import com.command.mediator.pojo.ProjectData;
import com.command.mediator.webservice.form.ProjectForm;

@RestController
@RequestMapping(value = "/mediator/v1/project", consumes = "application/json", produces = "application/json")
public class ProjectController extends BaseController{
	
	@Resource
	private ProjectHandler projectHandler;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<MediatorResponseModel> addProject(@Valid @RequestBody ProjectForm projectForm,
			BindingResult validationResults) {
		try {
			if (validationResults.hasErrors()) {
				return prepareValidationErrorResponse(validationResults, 0);
			}
			ProjectData projectData = projectHandler.addProject(projectForm);
			return prepareSuccessResponse(projectData, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<MediatorResponseModel> getProjectList() {
		try {
			List<ProjectData> list = projectHandler.getProjectList();
			return prepareSuccessResponse(list, list == null?0:list.size());
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
}
