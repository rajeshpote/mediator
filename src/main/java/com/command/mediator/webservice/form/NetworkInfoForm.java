package com.command.mediator.webservice.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NetworkInfoForm {

	@JsonProperty("device")
	private String device;
	
	@JsonProperty("boot_protocol")
	private String BootProtocol;
	
	@JsonProperty("ip")
	private String ip;
	
	@JsonProperty("netmask")
	private String netmask;
	
	@JsonProperty("bridge_name")
	private String bridgeName;
	
	@JsonProperty("nic")
	private String nic;

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getBootProtocol() {
		return BootProtocol;
	}

	public void setBootProtocol(String bootProtocol) {
		BootProtocol = bootProtocol;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}

	public String getBridgeName() {
		return bridgeName;
	}

	public void setBridgeName(String bridgeName) {
		this.bridgeName = bridgeName;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}
}
