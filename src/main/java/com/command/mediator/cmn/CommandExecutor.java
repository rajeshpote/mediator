package com.command.mediator.cmn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CommandExecutor {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommandExecutor.class);

	public static String execute(String command) {
		StringBuilder sb = new StringBuilder();
		String[] commands = new String[] { "/bin/bash", "-c", command };
		BufferedReader stdInput = null;
		BufferedReader stdError = null;
		try {
			Process proc = new ProcessBuilder(commands).start();
			stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

			stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

			String s = null;
			while ((s = stdInput.readLine()) != null) {
				sb.append(s);
				sb.append("\n");
			}

			while ((s = stdError.readLine()) != null) {
				sb.append(s);
				sb.append("\n");
			}
		} catch (IOException e) {
			LOGGER.error("Failed to execute command:{}, Error:{}", command, e);
			return e.getMessage();
		} finally {
			try {
				if (stdInput != null) {
					stdInput.close();
				}
				if (stdError != null) {
					stdError.close();
				}
			} catch (IOException e) {
				LOGGER.error("Error:{}", e);
			}
		}
		LOGGER.info("Executed command:{} \n output:{}", command, sb);
		return sb.toString();
	}

}
