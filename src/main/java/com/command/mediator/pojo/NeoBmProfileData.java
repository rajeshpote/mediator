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
	
	//net_type: dhcp or static
	@JsonProperty("network_type")
	@Column(name = "network_type")
	private String netType;
	
	//disk_part_type: auto or manual
	@Column(name = "disk_part_type")
	@JsonProperty("disk_part_type")
	private String diskPartType;
	
	@Column(name = "partitioning_info")
	@JsonProperty("partitioning_info")
	@OneToMany(cascade=CascadeType.ALL)
	private List<PartitioningInfo> partitioningInfo = new ArrayList<PartitioningInfo>();
	
	@Column(name = "network_Info")
	@JsonProperty("network_info")
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

	public String getNetType() {
		return netType;
	}

	public void setNetType(String netType) {
		this.netType = netType;
	}

	public String getDiskPartType() {
		return diskPartType;
	}

	public void setDiskPartType(String diskPartType) {
		this.diskPartType = diskPartType;
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
				+ packages + ", kvm=" + kvm + ", netType=" + netType + ", diskPartType=" + diskPartType
				+ ", partitioningInfo=" + partitioningInfo + ", networkInfo=" + networkInfo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NeoBmProfileData other = (NeoBmProfileData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
