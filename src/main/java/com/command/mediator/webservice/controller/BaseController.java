package com.command.mediator.webservice.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.command.mediator.model.ContentModel;
import com.command.mediator.model.MediatorResponseModel;
import com.command.mediator.model.MetadataModel;
import com.command.mediator.model.ServiceError;

public class BaseController {
	
	public HttpHeaders addAccessControllAllowOrigin() {
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Access-Control-Allow-Origin", "*");
	        return headers;
	    }

	  public ResponseEntity<MediatorResponseModel> prepareSuccessResponse(Object content, int contentListSize) {
	        ContentModel contentModel = new ContentModel();
	        contentModel.setContent(content);
	        MetadataModel metadataModel = new MetadataModel();
	        metadataModel.setRequestId(null);
	        metadataModel.setRequestParams(null);
	        metadataModel.setCount(contentListSize);
	        //metadataModel.setRequestTime(metadataModel.getRequestProcessingTime(requestStartTime));
	        metadataModel.setSuccess(Boolean.TRUE);
	        MediatorResponseModel MediatorResponseModel = new MediatorResponseModel(content == null ? null : contentModel, metadataModel, null);
	        return new ResponseEntity<MediatorResponseModel>(MediatorResponseModel, HttpStatus.OK);
	    }

	    public ResponseEntity<MediatorResponseModel> prepareNullResponse(long requestStartTime) {
	        MetadataModel metadataModel = new MetadataModel();
	        metadataModel.setRequestId(null);
	        metadataModel.setRequestParams(null);
	        metadataModel.setCount(0);
	        metadataModel.setRequestTime(metadataModel.getRequestProcessingTime(requestStartTime));
	        metadataModel.setSuccess(Boolean.TRUE);
	        MediatorResponseModel MediatorResponseModel = new MediatorResponseModel(null, metadataModel, null);
	        return new ResponseEntity<MediatorResponseModel>(MediatorResponseModel, HttpStatus.OK);
	    }

	    public ResponseEntity<MediatorResponseModel> prepareErrorResponse(Throwable throwable, int code, String fieldName) {
	        MetadataModel metadataModel = new MetadataModel();
	        metadataModel.setRequestId(null);
	        metadataModel.setRequestParams(null);
	       // metadataModel.setRequestTime(metadataModel.getRequestProcessingTime(requestStartTime));
	        ServiceError errorObj = new ServiceError(throwable.getCause().getMessage(), code, fieldName);
	        MediatorResponseModel MediatorResponseModel = new MediatorResponseModel(null, metadataModel, errorObj);
	        return new ResponseEntity<MediatorResponseModel>(MediatorResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    public ResponseEntity<MediatorResponseModel> prepareErrorResponse(String errorMsg, HttpStatus status, String fieldName, long requestStartTime) {
	        MetadataModel metadataModel = new MetadataModel();
	        metadataModel.setRequestId(null);
	        metadataModel.setRequestParams(null);
	        metadataModel.setRequestTime(metadataModel.getRequestProcessingTime(requestStartTime));
	        ServiceError errorObj = new ServiceError(errorMsg, status.value(), fieldName);
	        MediatorResponseModel MediatorResponseModel = new MediatorResponseModel(null, metadataModel, errorObj);
	        return new ResponseEntity<MediatorResponseModel>(MediatorResponseModel, status);
	    }
}
