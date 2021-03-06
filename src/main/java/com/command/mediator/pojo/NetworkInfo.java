package com.command.mediator.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "network_info")
public class NetworkInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "device")
	@JsonProperty("device")
	private String device;
	
	@Column(name = "boot_protocol")
	@JsonProperty("boot_protocol")
	private String BootProtocol;
	
	@Column(name = "ip")
	@JsonProperty("ip")
	private String ip;
	
	@Column(name = "netmask")
	@JsonProperty("netmask")
	private String netmask;
	
	@Column(name = "bridge_name")
	@JsonProperty("bridge_name")
	private String bridgeName;
	
	@Column(name = "nic")
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}
}
