package com.command.mediator.webservice.controller;

import java.util.List;

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
import com.command.mediator.handler.BmServerHandler;
import com.command.mediator.model.MediatorResponseModel;
import com.command.mediator.pojo.BmResponse;
import com.command.mediator.pojo.BmServerData;
import com.command.mediator.pojo.ProvisionBmServerData;
import com.command.mediator.webservice.form.AddBmServerForm;
import com.command.mediator.webservice.form.ProvisionBMServerForm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/mediator/v1/bm_server", consumes = "application/json", produces = "application/json")
public class BmController extends BaseController{
	
	private static Logger LOGGER = LoggerFactory.getLogger(BmController.class);
	
	@Resource
	private BmServerHandler bmServerHandler;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MediatorResponseModel> addBmServer(@RequestBody AddBmServerForm addBmServerForm) {
		try {
			BmServerData response = bmServerHandler.addBmServer(addBmServerForm);
			return prepareSuccessResponse(response, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<MediatorResponseModel> getBareMetalServerList() {
		try {
			List<BmServerData> bmServerList = bmServerHandler.getBmServer();
			return prepareSuccessResponse(bmServerList, bmServerList.size());
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}

	@RequestMapping(value  = "provision" ,method = RequestMethod.POST)
	public ResponseEntity<MediatorResponseModel> provisionBmServer(@RequestBody ProvisionBMServerForm provisionBMProfileForm) {
		try {
			ProvisionBmServerData response = bmServerHandler.provisionBmServer(provisionBMProfileForm);
			return prepareSuccessResponse(response, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
}
