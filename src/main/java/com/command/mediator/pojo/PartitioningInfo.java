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
	
	@Column(name = "type_of_partition")
	@JsonProperty("type_of_partition")
	private String typeOfPartition;
	
	@Column(name = "percentage_of_storage")
	@JsonProperty("percentage_of_storage")
	private int percentageOfStorage;
	
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
