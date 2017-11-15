package com.command.mediator.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "vm_deploy")
public class VmDeployData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@JsonProperty("ip_address")
	@Column(name = "ip_address")
	private String ipAddress;
	
	@JsonProperty("status")
	@Column(name = "status")
	private String status = "deployed";
	
	@JsonProperty("user_name")
	@Column(name = "user_name")
	private String userName;
	
	@JsonProperty("password")
	@Column(name = "password")
	private String password;
	
	@JsonProperty("vm_name")
	@Column(name = "vm_name")
	private String vmName;
	
	@JsonProperty("cpus")
	@Column(name = "cpus")
	private String cpus;
	
	@JsonProperty("ram")
	@Column(name = "ram")
	private String ram;
	
	@JsonProperty("storage")
	@Column(name = "storage")
	private Integer storage;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
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

	
	public String getVmName() {
		return vmName;
	}

	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	public String getCpus() {
		return cpus;
	}

	public void setCpus(String cpus) {
		this.cpus = cpus;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}