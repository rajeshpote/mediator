package com.command.mediator.webservice.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.command.mediator.handler.BmServerHandler;
import com.command.mediator.model.MediatorResponseModel;
import com.command.mediator.pojo.BmServerData;
import com.command.mediator.webservice.form.AddBmServerForm;
import com.command.mediator.webservice.form.ProvisionBMServerForm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/mediator/v1/bm", consumes = "application/json", produces = "application/json")
public class BmController extends BaseController{
	
	private static Logger LOGGER = LoggerFactory.getLogger(BmController.class);
	
	@Resource
	private BmServerHandler bmServerHandler;
	
	@RequestMapping(value  = "/add", method = RequestMethod.POST)
	public ResponseEntity<MediatorResponseModel> addBmServer(@RequestBody AddBmServerForm addBmServerForm) {
		try {
			BmServerData response = bmServerHandler.addBmServer(addBmServerForm);
			return prepareSuccessResponse(response, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value  = "/findAll",method = RequestMethod.GET)
	public ResponseEntity<MediatorResponseModel> getBareMetalServerList() {
		try {
			List<BmServerData> bmServerList = bmServerHandler.getBmServer();
			return prepareSuccessResponse(bmServerList, bmServerList.size());
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	@RequestMapping(value  = "/find/{id}",method = RequestMethod.GET)
	public ResponseEntity<MediatorResponseModel> getBareMetalServer(@PathVariable("id") String id) {
		try {
			BmServerData bmServer = bmServerHandler.getBmServer(id);
			return prepareSuccessResponse(bmServer, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}

	@RequestMapping(value  = "/provision" ,method = RequestMethod.POST)
	public ResponseEntity<MediatorResponseModel> provisionBmServer(@RequestBody ProvisionBMServerForm provisionBMProfileForm) {
		try {
			List<BmServerData> bmServerList = bmServerHandler.provisionBmServer(provisionBMProfileForm);
			return prepareSuccessResponse(bmServerList, bmServerList.size());
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MediatorResponseModel> updateBmServer(@PathVariable("id") String id, @Valid @RequestBody AddBmServerForm addBmServerForm,
           BindingResult validationResults) {
		try {
			if (validationResults.hasErrors()) {
				return prepareValidationErrorResponse(validationResults, 0);
			}
			BmServerData response = bmServerHandler.updateBmServer(id, addBmServerForm);
			return prepareSuccessResponse(response, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<MediatorResponseModel> updateBm(
    		@RequestParam(name = "bm_name", required = true) String bmName,
    		@RequestParam(name = "assigned_ip", required = false) String assignedIp,
    		@RequestParam(name = "status", required = false) String status,
    		@RequestParam(name = "cpu", required = false) String cpu,
    		@RequestParam(name = "memory", required = false) String memory,
    		@RequestParam(name = "logpath", required = false) String logpath,
    		@RequestParam(name = "username", required = false) String username,
    		@RequestParam(name = "password", required = false) String password) {
		try {
			BmServerData response = bmServerHandler.updateBm(bmName, assignedIp,status,cpu,memory,logpath,username,password);
			return prepareSuccessResponse(response, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<MediatorResponseModel> deleteBmServer(@PathVariable("id") int id) {
		try {
			bmServerHandler.deleteBmServer(id);
			return prepareSuccessResponse("success", 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value = "/stop", method = RequestMethod.GET)
	public ResponseEntity<MediatorResponseModel> stopBmServer(@RequestParam(name = "server-name") String serverName) {
		try {
			String response = bmServerHandler.stopBmServer(serverName);
			return prepareSuccessResponse(response, 1);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value = "/deprovision", method = RequestMethod.GET)
	public ResponseEntity<MediatorResponseModel> deprovisionBmServer(@RequestParam(name = "server-name") String serverNames) {
		try {
			String response = bmServerHandler.deprovisionBmServer(serverNames);
			return prepareSuccessResponse(response, 1);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
}
