package com.command.mediator.webservice.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateBareMetalServerForm {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("cobblerProfile")
	private String cobblerProfile;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("kernelOptions")
	private String kernelOptions;
	
	@JsonProperty("kernelOptionsPost")
	private String kernelOptionsPost;
	
	@JsonProperty("kickstartFile")
	private String kickstartFile;
	
	@JsonProperty("kickstartMetaData")
	private String kickstartMetaData;
	
	@JsonProperty("netbootEnabled")
	private String netbootEnabled;
	
	@JsonProperty("hostname")
	private String hostname;
	
	@JsonProperty("comment")
	private String comment;
	
	@JsonProperty("gateway")
	private String gateway;
	
	@JsonProperty("nameserver")
	private String nameserver;
	
	@JsonProperty("interface")
	private String serverInterface;
	
	@JsonProperty("macAddress")
	private String macAddress;
	
	@JsonProperty("powerManagement")
	private String powerManagement;
	
	@JsonProperty("powerManagementAddress")
	private String powerManagementAddress;

	@JsonProperty("username")
	private String username;
	
	@JsonProperty("password")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCobblerProfile() {
		return cobblerProfile;
	}

	public void setCobblerProfile(String cobblerProfile) {
		this.cobblerProfile = cobblerProfile;
	}

	public String getKernelOptions() {
		return kernelOptions;
	}

	public void setKernelOptions(String kernelOptions) {
		this.kernelOptions = kernelOptions;
	}

	public String getKickstartFile() {
		return kickstartFile;
	}

	public void setKickstartFile(String kickstartFile) {
		this.kickstartFile = kickstartFile;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getNameserver() {
		return nameserver;
	}

	public void setNameserver(String nameserver) {
		this.nameserver = nameserver;
	}

	public String getServerInterface() {
		return serverInterface;
	}

	public void setServerInterface(String serverInterface) {
		this.serverInterface = serverInterface;
	}

	public String getPowerManagement() {
		return powerManagement;
	}

	public void setPowerManagement(String powerManagement) {
		this.powerManagement = powerManagement;
	}

	public String getPowerManagementAddress() {
		return powerManagementAddress;
	}

	public void setPowerManagementAddress(String powerManagementAddress) {
		this.powerManagementAddress = powerManagementAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKernelOptionsPost() {
		return kernelOptionsPost;
	}

	public void setKernelOptionsPost(String kernelOptionsPost) {
		this.kernelOptionsPost = kernelOptionsPost;
	}

	public String getKickstartMetaData() {
		return kickstartMetaData;
	}

	public void setKickstartMetaData(String kickstartMetaData) {
		this.kickstartMetaData = kickstartMetaData;
	}

	public String getNetbootEnabled() {
		return netbootEnabled;
	}

	public void setNetbootEnabled(String netbootEnabled) {
		this.netbootEnabled = netbootEnabled;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CreateBareMetalServerForm [name=" + name + ", cobblerProfile=" + cobblerProfile + ", kernelOptions="
				+ kernelOptions + ", kernelOptionsPost=" + kernelOptionsPost + ", kickstartFile=" + kickstartFile
				+ ", kickstartMetaData=" + kickstartMetaData + ", netbootEnabled=" + netbootEnabled + ", hostname="
				+ hostname + ", comment=" + comment + ", gateway=" + gateway + ", nameserver=" + nameserver
				+ ", serverInterface=" + serverInterface + ", macAddress=" + macAddress + ", powerManagement="
				+ powerManagement + ", powerManagementAddress=" + powerManagementAddress + ", username=" + username
				+ ", password=" + password + "]";
	}
	
}
