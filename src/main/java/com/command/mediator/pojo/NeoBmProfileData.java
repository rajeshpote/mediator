package com.command.mediator.pojo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private Boolean kvm;
	
	@Column(name = "auto_partitioning")
	@JsonProperty("auto_partitioning")
	private Boolean autoPartitioning = Boolean.TRUE;
	
	@Column(name = "dhcp")
	@JsonProperty("dhcp")
	private Boolean dhcp = Boolean.TRUE;
	
	@Column(name = "partitioning_info")
	@JsonProperty("partitioning_info")
	@OneToMany(cascade=CascadeType.ALL)
	private List<PartitioningInfo> partitioningInfo = new ArrayList<PartitioningInfo>();
	
	@Column(name = "network_Info")
	@JsonProperty("network_Info")
	@OneToMany(cascade=CascadeType.ALL)
	private List<NetworkInfo> networkInfo = new ArrayList<NetworkInfo>();
	
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

	public Boolean getKvm() {
		return kvm;
	}

	public Boolean getAutoPartitioning() {
		return autoPartitioning;
	}

	public void setAutoPartitioning(Boolean autoPartitioning) {
		this.autoPartitioning = autoPartitioning;
	}

	public Boolean getDhcp() {
		return dhcp;
	}

	public void setDhcp(Boolean dhcp) {
		this.dhcp = dhcp;
	}

	public void setKvm(Boolean kvm) {
		this.kvm = kvm;
	}

	public List<PartitioningInfo> getPartitioningInfo() {
		return partitioningInfo;
	}

	public void setPartitioningInfo(List<PartitioningInfo> partitioningInfo) {
		this.partitioningInfo = partitioningInfo;
	}

	public List<NetworkInfo> getNetworkInfo() {
		return networkInfo;
	}

	public void setNetworkInfo(List<NetworkInfo> networkInfo) {
		this.networkInfo = networkInfo;
	}

	@Override
	public String toString() {
		return "NeoBmProfileData [id=" + id + ", neoProfileId=" + neoProfileId + ", imageId=" + imageId + ", packages="
				+ packages + ", kvm=" + kvm + ", autoPartitioning=" + autoPartitioning + ", dhcp=" + dhcp
				+ ", partitioningInfo=" + partitioningInfo + ", networkInfo=" + networkInfo + "]";
	}
}
