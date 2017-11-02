package com.command.mediator.webservice.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.command.mediator.handler.BMProfileHandler;
import com.command.mediator.pojo.BMProfileData;
import com.command.mediator.pojo.BmResponse;
import com.command.mediator.webservice.form.ProfileForm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/mediator/v1/cobbler", consumes = "application/json", produces = "application/json")
public class BMProfileController {
	
	@Resource
	private BMProfileHandler bmProfileHandler;
	
	@RequestMapping(value = "/bm_profile" , method = RequestMethod.POST)
	public ResponseEntity<BmResponse> saveBMProfile(@RequestBody BMProfileData bmProfileData){
		BmResponse response = bmProfileHandler.saveBMProfile(bmProfileData);
		return new ResponseEntity<BmResponse>(response,
				response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
