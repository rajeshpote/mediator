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

@Service
public class BMProfileHandler {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CobblerController.class);
	
	@Resource
	private BMProfileRepository bmProfileRepository;
	
	public BmResponse saveBMProfile(BMProfileData bmProfileData) {
		BMProfileData bmProfile = new BMProfileData();
		bmProfile.setName(bmProfile.getName());
		bmProfile.setDescription(bmProfile.getDescription());
		bmProfile.setImageId(bmProfile.getImageId());
		bmProfile.setKickstartFile(bmProfile.getKickstartFile());
		bmProfile.setCreatedBy(bmProfile.getCreatedBy());
		bmProfile.setCreatedOn(new Date());
		bmProfile.setNeoBmProfiles(bmProfile.getNeoBmProfiles());
		bmProfile.setNeoProfilesId(bmProfile.getNeoProfilesId());
		
		BMProfileData savedBMProfile = bmProfileRepository.insert(bmProfile);
		LOGGER.info("Bm Profile saved  " + savedBMProfile.toString());
		return new BmResponse(true, savedBMProfile.toString());
	}

}
