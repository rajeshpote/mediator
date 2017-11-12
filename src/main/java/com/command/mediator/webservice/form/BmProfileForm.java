package com.command.mediator.webservice.form;


import java.util.ArrayList;
import java.util.List;
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
	
	@JsonProperty("kvm")
	private boolean kvm;
	
	@JsonProperty("packages")
	private List<String> packages = new ArrayList<String>();
	
	@JsonProperty("partitioning_info")
	private List<PartitioningInfoForm> partitioningInfo;
	
	@JsonProperty("network_info")
	private List<NetworkInfoForm> networkInfo;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("created_on")
	private String createdOn;
	
	public boolean isKvm() {
		return kvm;
	}

	public void setKvm(boolean kvm) {
		this.kvm = kvm;
	}
	
	public List<PartitioningInfoForm> getPartitioningInfo() {
		return partitioningInfo;
	}

	public void setPartitioningInfo(List<PartitioningInfoForm> partitioningInfo) {
		this.partitioningInfo = partitioningInfo;
	}

	public List<NetworkInfoForm> getNetworkInfo() {
		return networkInfo;
	}

	public void setNetworkInfo(List<NetworkInfoForm> networkInfo) {
		this.networkInfo = networkInfo;
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
	
	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
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
