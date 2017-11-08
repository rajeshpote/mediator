package com.command.mediator.webservice.form;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProvisionBMServerForm {

	@NotBlank(message = "profile_id can not be null.")
	@JsonProperty("profile_id")
	private String profileId;
	
	@NotEmpty(message = "server_id can not be null.")
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
