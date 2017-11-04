package com.command.mediator.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "neo_bm_profile")
public class NeoBmProfileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "neo_profile_id")
	@JsonProperty("neo_profile_id")
	private Integer neoProfileId;

	@Column(name = "image_id")
	@JsonProperty("image_id")
	private String imageId;
	
	@Column(name = "packages")
	@JsonProperty("packages")
	private String packages;
	
	@Column(name = "kvm")
	@JsonProperty("kvm")
	private String kvm;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	
	

	public Integer getNeoProfileId() {
		return neoProfileId;
	}

	public void setNeoProfileId(Integer neoProfileId) {
		this.neoProfileId = neoProfileId;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public String getKvm() {
		return kvm;
	}

	public void setKvm(String kvm) {
		this.kvm = kvm;
	}

	@Override
	public String toString() {
		return "NeoBmProfileData [id=" + id + ", neoProfileId=" + neoProfileId + ", imageId=" + imageId + ", packages="
				+ packages + "]";
	}

}
