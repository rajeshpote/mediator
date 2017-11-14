package com.command.mediator.webservice.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StorageInfoForm {
	
	@JsonProperty("disk")
	private Integer disk;
	
	@JsonProperty("space_percentage")
	private Integer spacePercentage;
	
	@JsonProperty("mount_path")
	private String mountPath;
	
	public Integer getSpacePercentage() {
		return spacePercentage;
	}

	public void setSpacePercentage(Integer spacePercentage) {
		this.spacePercentage = spacePercentage;
	}

	public Integer getDisk() {
		return disk;
	}

	public String getMountPath() {
		return mountPath;
	}

	public void setMountPath(String mountPath) {
		this.mountPath = mountPath;
	}

	public void setDisk(Integer disk) {
		this.disk = disk;
	}
}
