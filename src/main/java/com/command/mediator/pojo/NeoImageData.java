package com.command.mediator.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "neo_image")
public class NeoImageData {
	
	@Id
	@Field(value = "id")
	private String id;
	
	@Field(value = "name")
	private String name;
	
	@Field(value = "description")
	private String description;
	
	@Field(value = "mount_path")
	private String mountPath;
	
	@Field(value = "isoPath")
	private String isoPath;
	
	public String getIsoPath() {
		return isoPath;
	}

	public void setIsoPath(String isoPath) {
		this.isoPath = isoPath;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMountPath() {
		return mountPath;
	}
	public void setMountPath(String mountPath) {
		this.mountPath = mountPath;
	}
	
	@Override
	public String toString() {
		return "NeoImageData [id=" + id + ", name=" + name + ", description=" + description + ", mountPath=" + mountPath
				+ ", isoPath=" + isoPath + "]";
	}

}
