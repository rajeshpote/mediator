package com.command.mediator.webservice.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.command.mediator.handler.NeoImageHandler;
import com.command.mediator.model.MediatorResponseModel;
import com.command.mediator.pojo.NeoImageData;
import com.command.mediator.webservice.form.NeoImageForm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/mediator/v1/image", consumes = "application/json", produces = "application/json")
public class NeoImageController extends BaseController {

	@Resource
	private NeoImageHandler neoImageHandler;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MediatorResponseModel> uploadImage(@Valid @RequestBody NeoImageForm neoImageForm,
			BindingResult validationResults) {
		try {
			if (validationResults.hasErrors()) {
				// return prepareValidationErrorResponse(validationResults,
				// requestStartTime);
			}
			NeoImageData data = neoImageHandler.uploadImage(neoImageForm);
			return prepareSuccessResponse(data, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<MediatorResponseModel> getImageList() {
		try {
			List<NeoImageData> data = neoImageHandler.getImageList();
			return prepareSuccessResponse(data, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}

}
