package com.command.mediator.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.command.mediator.cmn.CommandExecutor;

@Component
public class LogHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(LogHandler.class);

	private String GET_LOGS_COMMAND = "/home/neo/scripts/getLogs.sh";
	
	public String getLogs() {
		String output = CommandExecutor.execute(GET_LOGS_COMMAND);
		LOGGER.info("Logs {} : "+ output);
		return output;
	}

}
