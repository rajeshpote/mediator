package com.command.mediator.webservice.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.command.mediator.handler.CobblerHandler;
import com.command.mediator.pojo.CobblerResponse;
import com.command.mediator.webservice.form.AnsibleForm;
import com.command.mediator.webservice.form.BashForm;

@RestController
@RequestMapping(value = "/mediator/v1/cobbler", consumes = "application/json", produces = "application/json")
public class CobblerController {

	private static Logger LOGGER = LoggerFactory.getLogger(CobblerController.class);
	
	@Resource
	private CobblerHandler cobblerHandler;
	
	@RequestMapping(value = "/kickstart", method = RequestMethod.GET)
	public ResponseEntity<CobblerResponse> getKickstartFiles() {
		CobblerResponse response = cobblerHandler.getKickStartFiles();
		return new ResponseEntity<CobblerResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ResponseEntity<CobblerResponse> getCobblerProfiles() {
		CobblerResponse response = cobblerHandler.getCobblerProfiles();
		return new ResponseEntity<CobblerResponse>(response, HttpStatus.OK);
	}

}
