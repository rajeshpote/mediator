package com.command.mediator.cmn;

import org.springframework.stereotype.Service;

import com.command.mediator.webservice.form.BmProfileForm;

@Service
public class SaveProfiles {

	public String saveBMProfile(BmProfileForm profileForm) {
		// TODO: Save all information to DB
		return "BM profile saved";
	}

	public String saveVMProfile(BmProfileForm profileForm) {
		// TODO: Save all information to DB
		return "VM profile saved";
	}

	public String saveVMGroupProfile(BmProfileForm profileForm) {
		// TODO: Save all information to DB
		return "VM group profile saved";
	}

	public String getProfileList() {
		// TODO: DB query to get List of profiles created.
		return "BM profile"+" VM profilr"+" VM group profile";
	}

}
