package com.command.mediator.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.persistent.BmsProfileHistoryRepository;
import com.command.mediator.persistent.NeoBmProfileRepository;
import com.command.mediator.persistent.NeoImageRepository;
import com.command.mediator.pojo.BmsProfileHistoryData;
import com.command.mediator.pojo.NeoBmProfileData;
import com.command.mediator.pojo.NeoImageData;
import com.command.mediator.webservice.form.BmProfileForm;

@Service
public class BMProfileHandler extends BaseHandler {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BMProfileHandler.class);
	
	@Resource
	private NeoBmProfileRepository neoBmProfileRepository;
	
	@Resource
	private BmsProfileHistoryRepository bmsProfileMappingRepository;
	
	@Resource
	private NeoImageRepository neoImageRepository;
	
	public NeoBmProfileData saveBMProfile(BmProfileForm profileForm) {
		NeoBmProfileData neoBmProfile = createBmNeoProfileObject(profileForm);
		neoBmProfile = neoBmProfileRepository.save(neoBmProfile);
		LOGGER.info("Neo BM Profile saved: {} " + neoBmProfile);
		return neoBmProfile;
	}

	public List<NeoBmProfileData> getNeoBmProfile() {
		List<NeoBmProfileData> bmProfileList = (List<NeoBmProfileData>) neoBmProfileRepository.findAll();
		for (NeoBmProfileData neoBmProfileData : bmProfileList) {
			NeoImageData image = getImageData(neoBmProfileData.getImageId());
			neoBmProfileData.setImageName(image.getImageName());
		}
		LOGGER.info("Neo BM Profile list found: {} " + bmProfileList);
		return bmProfileList;
	}
	
	public void deleteBmProfile(int id) {
		neoBmProfileRepository.delete(id);
		LOGGER.info("Neo Profile deleted: {} ");
	}

	public NeoBmProfileData getProfile(String profileId) {
		NeoBmProfileData neoBmProfile = neoBmProfileRepository.findOne(Integer.valueOf(profileId));
		NeoImageData image = getImageData(neoBmProfile.getImageId());
		neoBmProfile.setImageName(image.getImageName());
		return neoBmProfile;
	}

	public List<NeoBmProfileData> getAllProfileList(Integer bmServerId) {
		List<BmsProfileHistoryData> profileHistoryList = bmsProfileMappingRepository.findByBmServerId(bmServerId);
		LOGGER.info("Neo Profile list for allocated BM server : {} "+profileHistoryList);
		List<NeoBmProfileData> profileData = new ArrayList<NeoBmProfileData>();
		for (BmsProfileHistoryData profileHistory : profileHistoryList) {
			NeoBmProfileData neoBmProfileData = neoBmProfileRepository.findOne(profileHistory.getProfileId());
			NeoImageData image = getImageData(neoBmProfileData.getImageId());
			neoBmProfileData.setImageName(image.getImageName());
			profileData.add(neoBmProfileData);
		}
		List<NeoBmProfileData> profiles = (List<NeoBmProfileData>) neoBmProfileRepository.findAll();
		for (NeoBmProfileData neoBmProfileData : profiles) {
			if(!profileData.equals(neoBmProfileData)){
				NeoImageData image = getImageData(neoBmProfileData.getImageId());
				neoBmProfileData.setImageName(image.getImageName());
				profileData.add(neoBmProfileData);
			}
		}
		LOGGER.info("Returning Neo Profile list : {} ",profileData);
		return profileData;
	}

	public NeoBmProfileData updateBMProfile(String id, BmProfileForm bmProfileForm) throws Exception {
		NeoBmProfileData bmProfile = neoBmProfileRepository.findOne(Integer.valueOf(id));
		if(Objects.isNull(bmProfile)){
			throw new Exception("BM profile not present with the given id.");
		}
		bmProfile = updateBMProfile(bmProfile, bmProfileForm);
		bmProfile = neoBmProfileRepository.save(bmProfile);
		return bmProfile;
	}
	private NeoImageData getImageData(String imageId) {
		try {
			NeoImageData image = neoImageRepository.findOne(Integer.parseInt(imageId));
			return image;
		} catch (NumberFormatException ne) {
			LOGGER.info("Imgae id is not number..so finding using image name");
			NeoImageData image = neoImageRepository.findByImageName(imageId);
			return image!=null?image:new NeoImageData();
		}
	}

	
}
