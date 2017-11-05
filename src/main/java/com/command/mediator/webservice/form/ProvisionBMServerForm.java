package com.command.mediator.webservice.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProvisionBMServerForm {

	@JsonProperty("select_profile_file")
	private String selectProfileFile;
	
	@JsonProperty("all_profile_fields")
	private BmProfileForm allProfileFields;
	
	@JsonProperty("selectServer")
	private String selectServer;
	
	public String getSelectProfileFile() {
		return selectProfileFile;
	}
	public void setSelectProfileFile(String selectProfileFile) {
		this.selectProfileFile = selectProfileFile;
	}
	public BmProfileForm getAllProfileFields() {
		return allProfileFields;
	}
	public void setAllProfileFields(BmProfileForm allProfileFields) {
		this.allProfileFields = allProfileFields;
	}
	public String getSelectServer() {
		return selectServer;
	}
	public void setSelectServer(String selectServer) {
		this.selectServer = selectServer;
	}
}
