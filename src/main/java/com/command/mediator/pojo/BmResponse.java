package com.command.mediator.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BmResponse {

	@JsonProperty("Success")
	private boolean success;
	
	@JsonProperty("output")
	private String output;

	public BmResponse() {
		super();
	}

	public BmResponse(boolean success, String output) {
		super();
		this.success = success;
		this.output = output;
	}


	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
	
}
