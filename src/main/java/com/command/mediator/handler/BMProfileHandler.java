package com.command.mediator.handler;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.mongo.BMProfileRepository;
import com.command.mediator.pojo.BMProfileData;
import com.command.mediator.pojo.BmResponse;
import com.command.mediator.webservice.controller.CobblerController;
import com.command.mediator.webservice.form.ProfileForm;

@Service
public class BMProfileHandler {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CobblerController.class);
	
	@Resource
	private BMProfileRepository bmProfileRepository;
	
	public BmResponse saveBMProfile(ProfileForm profileForm) {
		BMProfileData bmProfile = new BMProfileData();
		bmProfile.setName(profileForm.getName());
		bmProfile.setDescription(profileForm.getDescription());
		bmProfile.setImageId(profileForm.getImageId());
		bmProfile.setKickstartFile(profileForm.getKickstartFile());
		bmProfile.setCreatedBy(profileForm.getCreatedBy());
		bmProfile.setCreatedOn(new Date());
		bmProfile.setNeoBmProfiles(profileForm.getNeoBmProfiles());
		bmProfile.setNeoProfilesId(profileForm.getNeoProfilesId());
		LOGGER.info("Bm Prpfile name :" +profileForm.getName());
		BMProfileData savedBMProfile = bmProfileRepository.save(bmProfile);
		LOGGER.info("Bm Profile saved  " + savedBMProfile.toString());
		return new BmResponse(true, savedBMProfile.toString());
	}

}
