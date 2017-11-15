package com.command.mediator.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.cmn.CommandExecutor;
import com.command.mediator.persistent.VmDeployRepository;
import com.command.mediator.pojo.VmDeployData;
import com.command.mediator.webservice.controller.CobblerController;
import com.command.mediator.webservice.form.VmDeployForm;

@Service
public class VmHandler extends BaseHandler{

	private static Logger LOGGER = LoggerFactory.getLogger(CobblerController.class);

	
	@Resource
	private VmDeployRepository vmDeployRepository;
	
	public VmDeployData saveVm(VmDeployForm vmDeployForm) {
	VmDeployData vm = createVmProfile(vmDeployForm);	
	vm = vmDeployRepository.save(vm);
	return vm;
	}

	public String deployVm(VmDeployForm vmDeployForm) {
		VmDeployData vm = saveVm(vmDeployForm);
		String cmd = getVmDeployCommand(vmDeployForm);
		String output = CommandExecutor.execute(cmd);
		LOGGER.info("VM saved: {} " + vm);
		LOGGER.info("VM deploy command output: {} " + output);
		return output;
	}


}
