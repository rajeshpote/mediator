package com.command.mediator.webservice.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.command.mediator.handler.VmHandler;
import com.command.mediator.model.MediatorResponseModel;
import com.command.mediator.webservice.form.VmDeployForm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/mediator/v1/vm", consumes = "application/json", produces = "application/json")
public class VmController extends BaseController{

	@Resource
	private VmHandler vmHandler;
	
	@RequestMapping(value = "/deploy", method = RequestMethod.POST)
	public ResponseEntity<MediatorResponseModel> deployVm(@RequestBody VmDeployForm vmDeployForm)throws Exception{
		try {
			String response = vmHandler.deployVm(vmDeployForm);
			return prepareSuccessResponse(response, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
}
