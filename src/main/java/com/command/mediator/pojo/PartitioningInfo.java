package com.command.mediator.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "partitioning_info")
public class PartitioningInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "disk")
	@JsonProperty("disk")
	private int disk;
	
	@Column(name = "partition_type")
	@JsonProperty("partition_type")
	private String partitionType;
	
	@Column(name = "storage_percentage")
	@JsonProperty("storage_percentage")
	private int storagePercentage;
	
	@Column(name = "mount_path")
	@JsonProperty("mount_path")
	private String mountPath;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
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
