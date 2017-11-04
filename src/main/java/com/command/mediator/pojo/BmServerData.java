package com.command.mediator.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "bm_server")
public class BmServerData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	@JsonProperty("name")
	private String name;
	
	@Column(name = "interface_mac")
	@JsonProperty("interface_mac")
	private String interfaceMac;
	
	@Column(name = "pm_type")
	@JsonProperty("pm_type")
	private String pmType;
	
	@Column(name = "pm_address")
	@JsonProperty("pm_address")
	private String pmAddress;
	
	@Column(name = "pm_name")
	@JsonProperty("pm_name")
	private String pmName;
	
	@Column(name = "pm_password")
	@JsonProperty("pm_password")
	private String pmPassword;
	
	@Column(name = "status")
	@JsonProperty("status")
	private String status;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "modified_date")
	private Date modifiedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
