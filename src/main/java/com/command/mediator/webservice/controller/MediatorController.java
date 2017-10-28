package com.command.mediator.webservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.command.mediator.webservice.form.AnsibleForm;
import com.command.mediator.webservice.form.BashForm;

@RestController
@RequestMapping(value = "/mediator/v1/execute", consumes = "application/json", produces = "application/json")
public class MediatorController extends BaseController{

	private static Logger LOGGER = LoggerFactory.getLogger(MediatorController.class);
	
	/**
	 * 1. Input is count, array of names with size = count, template name (string)
		The web service will trigger a bash script which runs on the same machine. It will send all the params to the bash script. The result of the bash script will be success or failure. 
		If result is success then you will call another API server ( for today keep this as placeholder and harde the result as a json)
		If result is failure then - read a text file content and send back this failure message as a json 
	 * @param bashForm
	 * @return
	 */
	@RequestMapping(value = "/bash", method = RequestMethod.POST)
	public ResponseEntity<String> runBashCommand(@RequestBody BashForm bashForm) {
		// TODO: run the bash script and return the result
		LOGGER.info("Input bash form : {}", bashForm);
		return new ResponseEntity<String>("Success",addAccessControllAllowOrigin(), HttpStatus.OK);
	}

	/**
	 * 3. Input is vm name and a list of package names
		The web service will trigger ansible commands
		So need to explore ansible integration with java
	 * @param ansibleForm
	 * @return
	 */
	@RequestMapping(value = "/ansible", method = RequestMethod.POST)
	public ResponseEntity<String> runAnsibleCommand(@RequestBody AnsibleForm ansibleForm) {
		// TODO: run the ansible script and return the result
		LOGGER.info("Input ansible form : {}", ansibleForm);
		return new ResponseEntity<String>("Success",addAccessControllAllowOrigin(), HttpStatus.OK);
	}
	
	/**
	 * 2. Input is vm name
		The web service will trigger another API call
		Again hard code this
		Result is json 
	 * @param vmName
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ResponseEntity<String> runQuery(@RequestParam(name = "vm_name") String vmName) {
		// TODO: Query external API.
		LOGGER.info("Input vm name : {}", vmName);
		return new ResponseEntity<String>("Success", addAccessControllAllowOrigin(),HttpStatus.OK);
	}

}
