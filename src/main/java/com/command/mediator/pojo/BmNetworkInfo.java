package com.command.mediator.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "bm_network_info")
public class BmNetworkInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@JsonProperty("network_id")
	@Column(name = "network_id")
	private String networkId;
	
	@JsonProperty("mac")
	@Column(name = "mac")
	private String mac;

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	public String toString() {
		return "BmNetworkInfo [networkId=" + networkId + ", mac=" + mac + "]";
	}
	
}
