package com.command.mediator.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "vm_profile")
public class VmProfileData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "image")
	@JsonProperty("image")
	private String image;
	
	@Column(name = "profile_name")
	@JsonProperty("profile_name")
	private String profileName;
	
	@Column(name = "profile_description")
	@JsonProperty("profile_description")
	private String profileDescription;
	
	@Column(name = "cpu")
	@JsonProperty("cpu")
	private String cpu;
	
	@Column(name = "ram_memory")
	@JsonProperty("ram_memory")
	private String ramMemory;
	
	@Column(name = "storage_info")
	@JsonProperty("storage_info")
	@OneToMany(cascade = CascadeType.ALL)
	private List<StorageInfo> storageInfo = new ArrayList<StorageInfo>();
	
	@Column(name = "network_info")
	@JsonProperty("network_info")
	@OneToMany(cascade = CascadeType.ALL)
	private List<NetworkInfo> networkInfo = new ArrayList<NetworkInfo>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRamMemory() {
		return ramMemory;
	}

	public void setRamMemory(String ramMemory) {
		this.ramMemory = ramMemory;
	}

	public List<StorageInfo> getStorageInfo() {
		return storageInfo;
	}

	public void setStorageInfo(List<StorageInfo> storageInfo) {
		this.storageInfo = storageInfo;
	}

	public List<NetworkInfo> getNetworkInfo() {
		return networkInfo;
	}

	public void setNetworkInfo(List<NetworkInfo> networkInfo) {
		this.networkInfo = networkInfo;
	}

	
}