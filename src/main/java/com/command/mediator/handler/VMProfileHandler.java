package com.command.mediator.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.cmn.CommandExecutor;
import com.command.mediator.persistent.VmProfileRepository;
import com.command.mediator.pojo.VmProfileData;
import com.command.mediator.webservice.controller.CobblerController;
import com.command.mediator.webservice.form.VmProfileForm;

@Service
public class VMProfileHandler extends BaseHandler{

	private static Logger LOGGER = LoggerFactory.getLogger(CobblerController.class);

	private String DEPLOY_VM_COMMAND = "/home/neo/scripts/vm-deploy_iso.sh ";
	
	@Resource
	private VmProfileRepository vmProfileRepository;
	
	public VmProfileData saveVmProfile(VmProfileForm vmProfileForm) {
	VmProfileData vmProfile = createVmProfile(vmProfileForm);	
	vmProfile = vmProfileRepository.save(vmProfile);
	LOGGER.info("VM Profile saved: {} " + vmProfile);
	return vmProfile;
	}

	public String deployVmProfile(VmProfileForm vmProfileForm) {
		VmProfileData vmProfile = saveVmProfile(vmProfileForm);
		String output = CommandExecutor.execute(DEPLOY_VM_COMMAND + vmProfileForm.getIpAddress() + 
				" " + vmProfileForm.getRam() + " " + vmProfileForm.getCpus() + " " + vmProfileForm.getStorage());
		LOGGER.info("VM profile saved: {} " + vmProfile);
		LOGGER.info("VM deploy command output: {} " + output);
		return output;
	}
}
