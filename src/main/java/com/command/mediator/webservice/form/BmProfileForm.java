package com.command.mediator.webservice.form;


import javax.persistence.Column;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BmProfileForm {


	@JsonProperty("name")
	@NotBlank(message = "profile name can not be null.")
	private String name;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("image_id")
	private String imageId;
	
	@JsonProperty("kickstart_file")
	private String kickstartFile;
	
	@Column(name = "kvm")
	private String kvm;
	
	@Column(name = "packages")
	private String packages;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("created_on")
	private String createdOn;
	
	public String getKvm() {
		return kvm;
	}

	public void setKvm(String kvm) {
		this.kvm = kvm;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
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

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getKickstartFile() {
		return kickstartFile;
	}

	public void setKickstartFile(String kickstartFile) {
		this.kickstartFile = kickstartFile;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "ProfileForm [name=" + name + ", description=" + description + ", imageId=" + imageId
				+ ", kickstartFile=" + kickstartFile + ", createdBy=" + createdBy + ", createdOn=" + createdOn + "]";
	}

	
	
}
