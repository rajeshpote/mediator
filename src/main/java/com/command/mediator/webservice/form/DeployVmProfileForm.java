package com.command.mediator.webservice.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeployVmProfileForm {

	@JsonProperty("ip_address")
	private String image;
	
	@JsonProperty("user_name")
	private String userName;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("vm_name")
	private String vm_name;
	
	@JsonProperty("cpu")
	private String cpu;
	
	@JsonProperty("ram")
	private String ram;
	
	@JsonProperty("storage")
	private Integer storage;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVm_name() {
		return vm_name;
	}

	public void setVm_name(String vm_name) {
		this.vm_name = vm_name;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public Integer getStorage() {
		return storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}
}
