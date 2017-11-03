package com.command.mediator.pojo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "bm_profiles")
public class BMProfileData {
	
	@Id
	private String id;
	
	@Field(value = "name")
	private String name;
	
	@Field(value = "description")
	private String description;
	
	@Field(value = "imageId")
	private String imageId;
	
	@Field(value = "kickstarFile")
	private String kickstartFile;
	
	@Field(value = "createdBy")
	private String createdBy;
	
	@Field(value = "createdOn")
	private Date createdOn;
	
	@Field(value = "neoBmProfiles")
	private String neoBmProfiles;

	@Field(value = "neoProfilesId")
	private String neoProfilesId;

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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getNeoBmProfiles() {
		return neoBmProfiles;
	}

	public void setNeoBmProfiles(String neoBmProfiles) {
		this.neoBmProfiles = neoBmProfiles;
	}

	public String getNeoProfilesId() {
		return neoProfilesId;
	}

	public void setNeoProfilesId(String neoProfilesId) {
		this.neoProfilesId = neoProfilesId;
	}

	@Override
	public String toString() {
		return "ProfileForm [id=" + id + ", name=" + name + ", description=" + description + ", imageId=" + imageId
				+ ", kickstartFile=" + kickstartFile + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", neoBmProfiles=" + neoBmProfiles + ", neoProfilesId=" + neoProfilesId + "]";
	}

	
	
}
