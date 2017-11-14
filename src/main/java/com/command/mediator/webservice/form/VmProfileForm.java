package com.command.mediator.webservice.form;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VmProfileForm {

	@JsonProperty("image")
	@NotBlank(message = "image name can not be null.")
	private String image;
	
	@JsonProperty("profile_name")
	@NotBlank(message = "profile name can not be null.")
	private String profileName;
	
	@JsonProperty("profile_description")
	private String profileDescription;
	
	@JsonProperty("cpu")
	private String cpu;
	
	@JsonProperty("ram_memory")
	private String ramMemory;
	
	@JsonProperty("storage_info")
	private List<StorageInfoForm> storageInfo;
	
	@JsonProperty("network_info")
	private List<NetworkInfoForm> networkInfo;
	
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

	public List<StorageInfoForm> getStorageInfo() {
		return storageInfo;
	}

	public void setStorageInfo(List<StorageInfoForm> storageInfo) {
		this.storageInfo = storageInfo;
	}

	public List<NetworkInfoForm> getNetworkInfo() {
		return networkInfo;
	}

	public void setNetworkInfo(List<NetworkInfoForm> networkInfo) {
		this.networkInfo = networkInfo;
	}
	

}
