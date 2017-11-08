package com.command.mediator.webservice.form;


import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NeoImageForm {
	
	@JsonProperty("image_name")
	@NotBlank(message = "image name can not be null.")
	private String imageName;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("os_type")
	private String osType;
	
	@JsonProperty("mount_path")
	private String mountPath;
	
	@JsonProperty("iso_path")
	private String isoPath;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String name) {
		this.imageName = name;
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

	public String getIsoPath() {
		return isoPath;
	}

	public void setIsoPath(String isoPath) {
		this.isoPath = isoPath;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	@Override
	public String toString() {
		return "NeoImageForm [imageName=" + imageName + ", description=" + description + ", osType=" + osType
				+ ", mountPath=" + mountPath + ", isoPath=" + isoPath + "]";
	}
}
