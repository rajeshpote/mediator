package com.command.mediator.pojo;

import com.command.mediator.webservice.form.BmProfileForm;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProvisionBmServerData {
	
	private String selectProfileFile;
	
	private BmProfileForm allProfileFields;
	
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
