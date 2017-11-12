package com.command.mediator.webservice.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PartitioningInfoForm {
	
	@JsonProperty("disk")
	private int disk;
	
	@JsonProperty("type_of_partition")
	private String typeOfPartition;
	
	@JsonProperty("percentage_of_storage")
	private int percentageOfStorage;
	
	@JsonProperty("mount_path")
	private String mountPath;
	
	public int getDisk() {
		return disk;
	}
	
	public void setDisk(int disk) {
		this.disk = disk;
	}
	
	public String getTypeOfPartition() {
		return typeOfPartition;
	}
	
	public void setTypeOfPartition(String typeOfPartition) {
		this.typeOfPartition = typeOfPartition;
	}

	public int getPercentageOfStorage() {
		return percentageOfStorage;
	}
	
	public void setPercentageOfStorage(int percentageOfStorage) {
		this.percentageOfStorage = percentageOfStorage;
	}
	
	public String getMountPath() {
		return mountPath;
	}
	
	public void setMountPath(String mountPath) {
		this.mountPath = mountPath;
	}
}
