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
//@Table(name = "bms_profile_history_data")
public class BmsProfileHistoryData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "bm_server_id")
	@JsonProperty("bm_server_id")
	private Integer bmServerId;
	
	@Column(name = "profile_id")
	@JsonProperty("profile_id")
	private Integer profileId;
	
	@Column(name = "allocation_date")
	@JsonProperty("allocation_date")
	private Date allocationDate;
	
	public Date getAllocationDate() {
		return allocationDate;
	}
	public void setAllocationDate(Date allocationDate) {
		this.allocationDate = allocationDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBmServerId() {
		return bmServerId;
	}
	public void setBmServerId(Integer bmServerId) {
		this.bmServerId = bmServerId;
	}
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
}