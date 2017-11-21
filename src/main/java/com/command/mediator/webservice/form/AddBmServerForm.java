package com.command.mediator.webservice.form;

import java.util.List;

import com.command.mediator.pojo.BmDiskInfo;
import com.command.mediator.pojo.BmNetworkInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddBmServerForm {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("interface_mac")
	private String interfaceMac;
	
	@JsonProperty("pm_type")
	private String pmType;
	
	@JsonProperty("pm_address")
	private String pmAddress;
	
	@JsonProperty("pm_name")
	private String pmName;
	
	@JsonProperty("pm_password")
	private String pmPassword;
	
	@JsonProperty("project_id")
	private Integer projectId;
	
	@JsonProperty("disks")
	private List<BmDiskInfo> disks;
	
	@JsonProperty("networks")
	private List<BmNetworkInfo> networks;
	
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInterfaceMac() {
		return interfaceMac;
	}
	public void setInterfaceMac(String interfaceMac) {
		this.interfaceMac = interfaceMac;
	}
	public String getPmType() {
		return pmType;
	}
	public void setPmType(String pmType) {
		this.pmType = pmType;
	}
	public String getPmAddress() {
		return pmAddress;
	}
	public void setPmAddress(String pmAddress) {
		this.pmAddress = pmAddress;
	}
	public String getPmName() {
		return pmName;
	}
	public void setPmName(String pmName) {
		this.pmName = pmName;
	}
	public String getPmPassword() {
		return pmPassword;
	}
	public void setPmPassword(String pmPassword) {
		this.pmPassword = pmPassword;
	}
	public List<BmDiskInfo> getDisks() {
		return disks;
	}
	public void setDisks(List<BmDiskInfo> disks) {
		this.disks = disks;
	}
	public List<BmNetworkInfo> getNetworks() {
		return networks;
	}
	public void setNetworks(List<BmNetworkInfo> networks) {
		this.networks = networks;
	}
	
}
