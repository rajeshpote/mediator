package com.command.mediator.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "storage_info")
public class StorageInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "disk")
	@JsonProperty("disk")
	private Integer disk;
	
	@Column(name= "space_percentage")
	@JsonProperty("space_percentage")
	private Integer spacePercentage;
	
	@Column(name = "mount_path")
	@JsonProperty("mount_path")
	private String mountPath;
	
	public Integer getDisk() {
		return disk;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSpacePercentage() {
		return spacePercentage;
	}

	public void setSpacePercentage(Integer spacePercentage) {
		this.spacePercentage = spacePercentage;
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
