package com.command.mediator.pojo;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ProjectData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "project_name")
	@JsonProperty("project_name")
	private String projectNane;
	
	@Column(name = "project_description")
	@JsonProperty("project_description")
	private String projectDescription;
	
	@Column(name = "department")
	@JsonProperty("department")
	private String department;

	@Column(name = "allocated_BMs")
	@JsonProperty("allocated_BMs")
	private Integer allocatedBMs = 0;
	
	@Column(name = "unallocated_BMs")
	@JsonProperty("unallocated_BMs")
	private Integer unallocatedBMs = 0;
	
	@Column(name = "running_VMs")
	@JsonProperty("running_VMs")
	private Integer runningVMs = 0;
	
	@Column(name = "stopped_VMs")
	@JsonProperty("stopped_VMs")
	private Integer stoppedVMs = 0;
	
	@Column(name = "created_on")
	@JsonProperty("created_on")
	private Calendar createdOn ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getAllocatedBMs() {
		return allocatedBMs;
	}

	public void setAllocatedBMs(Integer allocatedBMs) {
		this.allocatedBMs = allocatedBMs;
	}

	public Integer getUnallocatedBMs() {
		return unallocatedBMs;
	}

	public void setUnallocatedBMs(Integer unallocatedBMs) {
		this.unallocatedBMs = unallocatedBMs;
	}

	public Integer getRunningVMs() {
		return runningVMs;
	}

	public void setRunningVMs(Integer runningVMs) {
		this.runningVMs = runningVMs;
	}

	public Integer getStoppedVMs() {
		return stoppedVMs;
	}

	public void setStoppedVMs(Integer stoppedVMs) {
		this.stoppedVMs = stoppedVMs;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
	
}
