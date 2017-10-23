package com.command.mediator.webservice.form;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnsibleForm {
	
	@JsonProperty("vm_name")
	private String vmName;
	
	@JsonProperty("packages")
	private List<String> packages = null;

	public String getVmName() {
		return vmName;
	}

	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}

	@Override
	public String toString() {
		return "AnsibleForm [vmName=" + vmName + ", packages=" + packages + "]";
	}

}
