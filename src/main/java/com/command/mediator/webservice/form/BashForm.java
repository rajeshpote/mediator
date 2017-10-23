package com.command.mediator.webservice.form;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BashForm {
	
	@JsonProperty("count")
	private String count;
	
	@JsonProperty("names")
	private List<String> names = null;
	
	@JsonProperty("templete_name")
	private String templeteName;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public String getTempleteName() {
		return templeteName;
	}

	public void setTempleteName(String templeteName) {
		this.templeteName = templeteName;
	}

	@Override
	public String toString() {
		return "BashForm [count=" + count + ", names=" + names + ", templeteName=" + templeteName + "]";
	}
	
	

}
