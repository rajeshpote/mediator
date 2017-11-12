package com.command.mediator.webservice.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PartitioningInfoForm {
	
	@JsonProperty("disk")
	private int disk;
	
	@JsonProperty("partition_type")
	private String partitionType;
	
	@JsonProperty("storage_percentage")
	private int storagePercentage;
	
	@JsonProperty("mount_path")
	private String mountPath;
	
	public int getDisk() {
		return disk;
	}
	
	public void setDisk(int disk) {
		this.disk = disk;
	}
	
	public String getPartitionType() {
		return partitionType;
	}

	public void setPartitionType(String partitionType) {
		this.partitionType = partitionType;
	}

	public int getStoragePercentage() {
		return storagePercentage;
	}

	public void setStoragePercentage(int storagePercentage) {
		this.storagePercentage = storagePercentage;
	}

	public String getMountPath() {
		return mountPath;
	}
	
	public void setMountPath(String mountPath) {
		this.mountPath = mountPath;
	}
}
