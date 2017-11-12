package com.command.mediator.webservice.form;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectForm {

	@JsonProperty("project_name")
	@NotBlank(message = "project name can not be null")
	private String projectNane;
	
	@JsonProperty("project_description")
	private String projectDescription;
	
	@JsonProperty("department")
	private String department;

	public String getProjectNane() {
		return projectNane;
	}

	public void setProjectNane(String projectNane) {
		this.projectNane = projectNane;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
