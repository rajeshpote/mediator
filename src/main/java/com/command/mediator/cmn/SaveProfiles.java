package com.command.mediator.cmn;

import org.springframework.stereotype.Service;

import com.command.mediator.webservice.form.ProfileForm;

@Service
public class SaveProfiles {

	public String saveBMProfile(ProfileForm profileForm) {
		// TODO: Save all information to DB
		return "BM profile saved";
	}

	public String saveVMProfile(ProfileForm profileForm) {
		// TODO: Save all information to DB
		return "VM profile saved";
	}

	public String saveVMGroupProfile(ProfileForm profileForm) {
		// TODO: Save all information to DB
		return "VM group profile saved";
	}

	public String getProfileList() {
		// TODO: DB query to get List of profiles created.
		return "BM profile"+" VM profilr"+" VM group profile";
	}

}
