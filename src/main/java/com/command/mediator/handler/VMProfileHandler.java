package com.command.mediator.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.command.mediator.persistent.VmProfileRepository;
import com.command.mediator.pojo.VmProfileData;
import com.command.mediator.webservice.controller.CobblerController;
import com.command.mediator.webservice.form.VmProfileForm;

@Service
public class VMProfileHandler extends BaseHandler{

	private static Logger LOGGER = LoggerFactory.getLogger(CobblerController.class);
	
	@Resource
	private VmProfileRepository vmProfileRepository;
	
	public VmProfileData saveVmProfile(VmProfileForm vmProfileForm) {
	VmProfileData vmProfile = createVmProfile(vmProfileForm);	
	vmProfile = vmProfileRepository.save(vmProfile);
	LOGGER.info("VM Profile saved: {} " + vmProfile);
	return vmProfile;
	}
}
