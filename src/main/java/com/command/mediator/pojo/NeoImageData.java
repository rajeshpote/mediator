package com.command.mediator.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "neo_image")
public class NeoImageData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "image_name")
	@JsonProperty("image_name")
	private String imageName;
	
	@Column(name = "description")
	@JsonProperty("description")
	private String description;
	
	@Column(name = "mount_path")
	@JsonProperty("mount_path")
	private String mountPath;
	
	@Column(name = "iso_path")
	@JsonProperty("iso_path")
	private String isoPath;
	
	
	public String getIsoPath() {
		return isoPath;
	}

	public void setIsoPath(String isoPath) {
		this.isoPath = isoPath;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
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
		return "NeoImageData [id=" + id + ", imageName=" + imageName + ", description=" + description + ", mountPath=" + mountPath
				+ ", isoPath=" + isoPath + "]";
	}

}
