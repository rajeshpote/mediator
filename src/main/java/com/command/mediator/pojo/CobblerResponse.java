package com.command.mediator.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CobblerResponse {
	
	@JsonProperty("label")
	private String label;
	
	@JsonProperty("value")
	private String value;
	
	public CobblerResponse(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}

	public CobblerResponse() {
		super();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
