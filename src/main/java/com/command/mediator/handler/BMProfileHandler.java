package com.command.mediator.handler;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.command.mediator.persistent.NeoBmProfileRepository;
import com.command.mediator.persistent.NeoProfileRepository;
import com.command.mediator.pojo.NeoBmProfileData;
import com.command.mediator.pojo.NeoProfileData;
import com.command.mediator.webservice.controller.CobblerController;
import com.command.mediator.webservice.form.BmProfileForm;

@Service
public class BMProfileHandler extends BaseHandler {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CobblerController.class);
	
	@Resource
	private NeoProfileRepository neoProfileRepository;
	
	@Resource
	private NeoBmProfileRepository neoBmProfileRepository;
	
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

}
