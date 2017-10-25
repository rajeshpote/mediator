package com.command.mediator.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.cmn.CommandExecutor;
import com.command.mediator.pojo.CobblerResponse;
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

	public String createBareMetalServer(CreateBareMetalServerForm serverForm) {
		String command = getAddCobblerCommand(serverForm);
		String output = commandExecutor.execute(command);
		if(output == null || output.contains("exception on server")){
			return "Failure";
		}
		//2nd command: cobbler system reboot --name=system-object-name
		String rebbotOutput = commandExecutor.execute(COBBLER_REBOOT_COMMAND+serverForm.getName());
		if(rebbotOutput == null || rebbotOutput.contains("failed to execute")){
			return "Failure";
		}
		return "Success";
	}

	private String getAddCobblerCommand(CreateBareMetalServerForm serverForm) {
		StringBuilder addCobblercommand = new StringBuilder("cobbler system add");
		addCobblercommand.append(" --name=").append("\"").append(serverForm.getName()).append("\"");
		addCobblercommand.append(" --hostname=").append("\"").append(serverForm.getHostname()).append("\"");
		addCobblercommand.append(" --profile=").append("\"").append(serverForm.getCobblerProfile()).append("\"");
		addCobblercommand.append(" --status=").append("\"").append(serverForm.getStatus()).append("\"");
		addCobblercommand.append(" --kopts=").append("\"").append(serverForm.getKernelOptions()).append("\"");
		addCobblercommand.append(" --kopts-post=").append("\"").append(serverForm.getKernelOptionsPost()).append("\"");
		addCobblercommand.append(" --ksmeta=").append("\"").append(serverForm.getKickstartMetaData()).append("\"");
		addCobblercommand.append(" --netboot-enabled=").append("\"").append(serverForm.getNetbootEnabled()).append("\"");
		addCobblercommand.append(" --kickstart=").append("\"").append(serverForm.getKickstartFile()).append("\"");
		addCobblercommand.append(" --comment=").append("\"").append(serverForm.getComment()).append("\"");
		addCobblercommand.append(" --power-type=").append("\"").append(serverForm.getPowerManagement()).append("\"");
		addCobblercommand.append(" --power-address=").append("\"").append(serverForm.getPowerManagementAddress()).append("\"");
		addCobblercommand.append(" --power-user=").append("\"").append(serverForm.getUsername()).append("\"");
		addCobblercommand.append(" --power-pass=").append("\"").append(serverForm.getPassword()).append("\"");
		addCobblercommand.append(" --mac-address=").append("\"").append(serverForm.getMacAddress()).append("\"");
		addCobblercommand.append(" --interface=").append("\"").append(serverForm.getServerInterface()).append("\"");
		return addCobblercommand.toString();
	}
}
