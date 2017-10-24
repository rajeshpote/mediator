package com.command.mediator.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.cmn.CommandExecutor;
import com.command.mediator.pojo.CobblerResponse;

@Service
public class CobblerHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(CobblerHandler.class);
	
	@Resource
	private CommandExecutor commandExecutor;
	
	private String KICKSTART_DIR ="/var/lib/cobbler/kickstarts/";
	private String CD_COMMAND ="cd ";
	private String COBBLER_PROFILE_COMMAND ="cobbler profile list";

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
}
