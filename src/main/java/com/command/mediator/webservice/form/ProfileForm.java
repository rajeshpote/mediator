package com.command.mediator.webservice.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfileForm {

	@JsonProperty("select_image")
	private String selectImage;
	
	@JsonProperty("profile_name")
	private String profileName;
	
	@JsonProperty("profile_description")
	private String profileDescription;
	
	@JsonProperty("kickstartFile")
	private String kickstartFile;
	
	@JsonProperty("setup_kvm")
	private String setupKvm;
	
	@JsonProperty("install_packages")
	private String installPackages;

	public String getSelectImage() {
		return selectImage;
	}

	public void setSelectImage(String selectImage) {
		this.selectImage = selectImage;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public String getKickstartFile() {
		return kickstartFile;
	}

	public void setKickstartFile(String kickstartFile) {
		this.kickstartFile = kickstartFile;
	}

	public String getSetupKvm() {
		return setupKvm;
	}

	public void setSetupKvm(String setupKvm) {
		this.setupKvm = setupKvm;
	}

	public String getInstallPackages() {
		return installPackages;
	}

	public void setInstallPackages(String installPackages) {
		this.installPackages = installPackages;
	}
	
}
