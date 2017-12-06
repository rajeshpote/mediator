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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.command.mediator.handler.LogHandler;
import com.command.mediator.model.MediatorResponseModel;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/mediator/v1/log",  consumes = "application/json", produces = "application/json")
public class LogController extends BaseController{
	
	private static Logger LOGGER = LoggerFactory.getLogger(LogController.class);
	
	@Resource
	private LogHandler logHandler;
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<MediatorResponseModel> getLogs(@RequestParam(name="server-name") String serverName) {
		try {
			String response = logHandler.getLogs(serverName);
			return prepareSuccessResponse(response, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}

}
