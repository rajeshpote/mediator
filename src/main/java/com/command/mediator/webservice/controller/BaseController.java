package com.command.mediator.webservice.controller;

import org.springframework.http.HttpHeaders;

public class BaseController {
	
	public HttpHeaders addAccessControllAllowOrigin() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Access-Control-Allow-Origin", "*");
	        return headers;
	    }

}
