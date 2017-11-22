package com.command.mediator.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ProjectData implements Comparable<ProjectData>{
	
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

	@Transient
	@JsonProperty("allocated_BMs")
	private long allocatedBMs = 0;
	
	@Transient
	@JsonProperty("unallocated_BMs")
	private long unallocatedBMs = 0;
	
	@Transient
	@JsonProperty("running_VMs")
	private long runningVMs = 0;
	
	@Transient
	@JsonProperty("stopped_VMs")
	private long stoppedVMs = 0;
	
	@Column(name = "created_on")
	@JsonProperty("created_on")
	private Date createdOn ;

	public Integer getId() {
		return id;
	}

	public long getAllocatedBMs() {
		return allocatedBMs;
	}

	public void setAllocatedBMs(long allocatedBMs) {
		this.allocatedBMs = allocatedBMs;
	}

	public long getUnallocatedBMs() {
		return unallocatedBMs;
	}

	public void setUnallocatedBMs(long unallocatedBMs) {
		this.unallocatedBMs = unallocatedBMs;
	}

	public long getRunningVMs() {
		return runningVMs;
	}

	public void setRunningVMs(long runningVMs) {
		this.runningVMs = runningVMs;
	}

	public long getStoppedVMs() {
		return stoppedVMs;
	}

	public void setStoppedVMs(long stoppedVMs) {
		this.stoppedVMs = stoppedVMs;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Override
	public int compareTo(ProjectData obj) {
		return obj.getCreatedOn().compareTo(this.getCreatedOn());
	}
}
