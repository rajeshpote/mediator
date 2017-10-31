package com.command.mediator.webservice.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageForm {
	
	@JsonProperty("file_name")
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
