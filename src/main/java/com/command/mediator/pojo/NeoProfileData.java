package com.command.mediator.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "neo_profile")
public class NeoProfileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name")
	@JsonProperty("name")
	private String name;
	
	@Column(name = "description")
	@JsonProperty("description")
	private String description;
	
	@Column(name = "image_id")
	@JsonProperty("image_id")
	private String imageId;
	
	@Column(name = "kickstart_file")
	@JsonProperty("kickstart_file")
	private String kickstartFile;
	
	@Column(name = "kvm")
	@JsonProperty("kvm")
	private String kvm;
	
	@Column(name = "packages")
	@JsonProperty("packages")
	private String packages;
	
	@Column(name = "created_by")
	@JsonProperty("created_by")
	private String createdBy;
	
	@Column(name = "created_on")
	@JsonProperty("created_on")
	private Date createdOn;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	@Override
	public String toString() {
		return "NeoProfileData [id=" + id + ", name=" + name + ", description=" + description + ", imageId=" + imageId
				+ ", kickstartFile=" + kickstartFile + ", createdBy=" + createdBy + ", createdOn=" + createdOn + "]";
	}

}
