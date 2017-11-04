package com.command.mediator.webservice.form;

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
	
}
