package com.command.mediator.webservice.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.command.mediator.handler.NeoImageHandler;
import com.command.mediator.pojo.BmResponse;
import com.command.mediator.pojo.NeoImageData;
import com.command.mediator.webservice.form.ImageForm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/mediator/v1/cobbler", consumes = "application/json", produces = "application/json")
public class NeoImageController extends BaseController{
	
	@Resource
	private NeoImageHandler neoImageHandler;

	@RequestMapping(value = "/image" , method = RequestMethod.POST)
	public ResponseEntity<BmResponse> uploadImage(@RequestBody NeoImageData imageForm){
		BmResponse response = neoImageHandler.uploadImage(imageForm);
		return new ResponseEntity<BmResponse>(response,
				response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/image" , method = RequestMethod.GET)
	public ResponseEntity<BmResponse> getImageList(){
		BmResponse response = neoImageHandler.getImageList();
		return new ResponseEntity<BmResponse>(response,
				response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
