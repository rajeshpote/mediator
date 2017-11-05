package com.command.mediator.webservice.form;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProvisionBMServerForm {

	@JsonProperty("profile_id")
	private String profileId;
	
	@JsonProperty("server_id")
	private List<String> serverId;

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public List<String> getServerId() {
		return serverId;
	}

	public void setServerId(List<String> serverId) {
		this.serverId = serverId;
	}
	
	
}
