package com.command.mediator.webservice.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.command.mediator.handler.CobblerHandler;
import com.command.mediator.pojo.CobblerResponse;
import com.command.mediator.webservice.form.CreateBareMetalServerForm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/mediator/v1/cobbler", consumes = "application/json", produces = "application/json")
public class CobblerController  extends BaseController{

	private static Logger LOGGER = LoggerFactory.getLogger(CobblerController.class);
	
	@Resource
	private CobblerHandler cobblerHandler;
	
	@RequestMapping(value = "/kickstart", method = RequestMethod.GET)
	public ResponseEntity<CobblerResponse> getKickstartFiles() {
		CobblerResponse response = cobblerHandler.getKickStartFiles();
		return new ResponseEntity<CobblerResponse>(response,addAccessControllAllowOrigin(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ResponseEntity<CobblerResponse> getCobblerProfiles() {
		CobblerResponse response = cobblerHandler.getCobblerProfiles();
		return new ResponseEntity<CobblerResponse>(response,addAccessControllAllowOrigin(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/server", method = RequestMethod.POST)
	public ResponseEntity<String> createBareMetalServer(@RequestBody CreateBareMetalServerForm serverForm) {
		LOGGER.info("Input server form : {}", serverForm);
		String response = cobblerHandler.createBareMetalServer(serverForm);
		return new ResponseEntity<String>(response, addAccessControllAllowOrigin(),HttpStatus.OK);
	}

}
