package com.command.mediator.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.persistent.BmsProfileHistoryRepository;
import com.command.mediator.persistent.NeoBmProfileRepository;
import com.command.mediator.persistent.NeoProfileRepository;
import com.command.mediator.pojo.BmsProfileHistoryData;
import com.command.mediator.pojo.NeoBmProfileData;
import com.command.mediator.pojo.NeoProfileData;
import com.command.mediator.webservice.controller.CobblerController;
import com.command.mediator.webservice.form.BmProfileForm;

@Service
public class BMProfileHandler extends BaseHandler {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BMProfileHandler.class);
	
	@Resource
	private NeoProfileRepository neoProfileRepository;
	
	@Resource
	private NeoBmProfileRepository neoBmProfileRepository;
	
	@Resource
	private BmsProfileHistoryRepository bmsProfileMappingRepository;
	
	public NeoProfileData saveBMProfile(BmProfileForm profileForm) {
		NeoProfileData bmProfile = createBmProfileObject(profileForm);
		bmProfile = neoProfileRepository.save(bmProfile);
		LOGGER.info("Neo Profile saved: {} " + bmProfile);
		
		NeoBmProfileData neoBmProfile = createBmNeoProfileObject(profileForm, bmProfile.getId());
		neoBmProfile = neoBmProfileRepository.save(neoBmProfile);
		LOGGER.info("Neo BM Profile saved: {} " + neoBmProfile);
		return bmProfile;
	}

	public List<NeoProfileData> getNeoProfile() {
		List<NeoProfileData> bmProfileList = (List<NeoProfileData>) neoProfileRepository.findAll();
		LOGGER.info("Neo Profile list found: {} " + bmProfileList);
		return bmProfileList;
	}

	public List<NeoBmProfileData> getNeoBmProfile() {
		List<NeoBmProfileData> bmProfileList = (List<NeoBmProfileData>) neoBmProfileRepository.findAll();
		LOGGER.info("Neo BM Profile list found: {} " + bmProfileList);
		return bmProfileList;
	}
	
	public void deleteBmProfile(int id) {
		neoBmProfileRepository.delete(id);
		LOGGER.info("Neo Profile deleted: {} ");
	}

	public NeoBmProfileData getProfile(String profileId) {
		NeoBmProfileData neoBmProfile = neoBmProfileRepository.findOne(Integer.valueOf(profileId));
		return neoBmProfile;
	}

	public List<NeoBmProfileData> getAllProfileList(Integer bmServerId) {
		List<BmsProfileHistoryData> profileHistoryList = bmsProfileMappingRepository.findByBmServerId(bmServerId);
		LOGGER.info("Neo Profile list for allocated BM server : {} "+profileHistoryList);
		List<NeoBmProfileData> profileData = new ArrayList<NeoBmProfileData>();
		for (BmsProfileHistoryData profileHistory : profileHistoryList) {
			profileData.add(neoBmProfileRepository.findOne(profileHistory.getProfileId()));
		}
		List<NeoBmProfileData> profiles = (List<NeoBmProfileData>) neoBmProfileRepository.findAll();
		for (NeoBmProfileData neoBmProfileData : profiles) {
			if(!profileData.equals(neoBmProfileData)){
				profileData.add(neoBmProfileData);
			}
		}
		LOGGER.info("Returning Neo Profile list : {} ",profileData);
		return profileData;
	}
}
