package com.command.mediator.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.command.mediator.cmn.CommandExecutor;
import com.command.mediator.pojo.CobblerResponse;
import com.command.mediator.pojo.BmResponse;
import com.command.mediator.webservice.form.CreateBareMetalServerForm;

@Service
public class CobblerHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(CobblerHandler.class);
	
	@Resource
	private CommandExecutor commandExecutor;
	
	private String KICKSTART_DIR ="/var/lib/cobbler/kickstarts/";
	private String CD_COMMAND ="cd ";
	private String COBBLER_PROFILE_COMMAND ="cobbler profile list";
	private String COBBLER_REBOOT_COMMAND ="cobbler system reboot --name=";
	public CobblerResponse getKickStartFiles() {
		StringBuilder response= new StringBuilder();
		String result = commandExecutor.execute(CD_COMMAND+KICKSTART_DIR+";ls");
		String files[] = result.split("\\n");
		for(String file: files) {
			response.append(KICKSTART_DIR+file+", ");
		}
		CobblerResponse responseObj = new CobblerResponse(response.toString(),response.toString());
		return responseObj;
	}

	public CobblerResponse getCobblerProfiles() {
		StringBuilder response= new StringBuilder();
		String result = commandExecutor.execute(COBBLER_PROFILE_COMMAND);
		String profiles[] = result.split("\\n");
		for(String profile: profiles) {
			response.append(profile+",");
		}
		CobblerResponse responseObj = new CobblerResponse(response.toString(),response.toString());
		return responseObj;
	}

	public BmResponse createBareMetalServer(CreateBareMetalServerForm serverForm) {
		String command = getAddCobblerCommand(serverForm);
		String output = commandExecutor.execute(command);
		if(output != null && output.contains("exception on server")){
			return new BmResponse(false,output);
		}
		//2nd command: cobbler system reboot --name=system-object-name
		String rebbotOutput = commandExecutor.execute(COBBLER_REBOOT_COMMAND+serverForm.getName());
		if(rebbotOutput != null && rebbotOutput.contains("failed to execute")){
			return new BmResponse(false,output);
		}
		return new BmResponse(true,rebbotOutput);
	}

	private String getAddCobblerCommand(CreateBareMetalServerForm serverForm) {
		StringBuilder addCobblercommand = new StringBuilder("cobbler system add");
		if(!StringUtils.isEmpty(serverForm.getName()))
			addCobblercommand.append(" --name=").append("\"").append(serverForm.getName()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getHostname()))
			addCobblercommand.append(" --hostname=").append("\"").append(serverForm.getHostname()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getCobblerProfile()))
			addCobblercommand.append(" --profile=").append("\"").append(serverForm.getCobblerProfile()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getStatus()))
			addCobblercommand.append(" --status=").append("\"").append(serverForm.getStatus()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getKernelOptions()))
			addCobblercommand.append(" --kopts=").append("\"").append(serverForm.getKernelOptions()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getKernelOptionsPost()))
			addCobblercommand.append(" --kopts-post=").append("\"").append(serverForm.getKernelOptionsPost()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getKickstartMetaData()))
			addCobblercommand.append(" --ksmeta=").append("\"").append(serverForm.getKickstartMetaData()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getNetbootEnabled()))
			addCobblercommand.append(" --netboot-enabled=").append("\"").append(serverForm.getNetbootEnabled()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getKickstartFile()))
			addCobblercommand.append(" --kickstart=").append("\"").append(serverForm.getKickstartFile()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getComment()))
			addCobblercommand.append(" --comment=").append("\"").append(serverForm.getComment()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getPowerManagement()))
			addCobblercommand.append(" --power-type=").append("\"").append(serverForm.getPowerManagement()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getPowerManagementAddress()))
			addCobblercommand.append(" --power-address=").append("\"").append(serverForm.getPowerManagementAddress()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getUsername()))
			addCobblercommand.append(" --power-user=").append("\"").append(serverForm.getUsername()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getPassword()))
			addCobblercommand.append(" --power-pass=").append("\"").append(serverForm.getPassword()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getMacAddress()))
			addCobblercommand.append(" --mac-address=").append("\"").append(serverForm.getMacAddress()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getServerInterface()))
			addCobblercommand.append(" --interface=").append("\"").append(serverForm.getServerInterface()).append("\"");
		
		return addCobblercommand.toString();
	}
}
