package com.command.mediator.webservice.form;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfileForm {

	/**
	 * "Save all informaton to DB
DB table:
neo_profiles: id, name, desc, image_id <FK to image table>, 
kickstart_file <entire raw file>, created_by, created_on
neo_bm_profiles: id, neo_profiles_id, <all-other-information>"
	*/
	@Id
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("imageId")
	private String imageId;
	
	@JsonProperty("kickstartFile")
	private String kickstartFile;
	
	@JsonProperty("createdBy")
	private String createdBy;
	
	@JsonProperty("createdOn")
	private String createdOn;
	
	@JsonProperty("neoBmProfiles")
	private String neoBmProfiles;

	@JsonProperty("neoProfilesId")
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

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
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
