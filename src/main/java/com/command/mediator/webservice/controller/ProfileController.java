package com.command.mediator.webservice.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
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
import com.command.mediator.handler.BMProfileHandler;
import com.command.mediator.handler.VmHandler;
import com.command.mediator.model.MediatorResponseModel;
import com.command.mediator.pojo.NeoBmProfileData;
import com.command.mediator.pojo.NeoProfileData;
import com.command.mediator.pojo.VmDeployData;
import com.command.mediator.webservice.form.BmProfileForm;
import com.command.mediator.webservice.form.VmDeployForm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/mediator/v1/profile", consumes = "application/json", produces = "application/json")
public class ProfileController extends BaseController {

	@Resource
	private BMProfileHandler bmProfileHandler;

	@Resource
	private VmHandler vmProfileHandler;
	
	@RequestMapping(value = "/bm", method = RequestMethod.POST)
	public ResponseEntity<MediatorResponseModel> saveBmProfile(@Valid @RequestBody BmProfileForm profileForm,
			BindingResult validationResults) {
		try {
			if (validationResults.hasErrors()) {
				return prepareValidationErrorResponse(validationResults, 0);
			}
			NeoProfileData response = bmProfileHandler.saveBMProfile(profileForm);
			return prepareSuccessResponse(response, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}

	@RequestMapping(value = "/bm", method = RequestMethod.GET)
	public ResponseEntity<MediatorResponseModel> getBmProfile() {
		try {
			List<NeoBmProfileData> list = bmProfileHandler.getNeoBmProfile();
			return prepareSuccessResponse(list, list == null?0:list.size());
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value = "/bm/{profile_id}",method = RequestMethod.GET)
	public ResponseEntity<MediatorResponseModel> getProfile(@PathVariable("profile_id") String profileId) {
		try {
			NeoBmProfileData data = bmProfileHandler.getProfile(profileId);
			return prepareSuccessResponse(data, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MediatorResponseModel> updateBmProfile(@PathVariable("id") String id, @Valid @RequestBody BmProfileForm profileForm,
           BindingResult validationResults) {
		try {
			if (validationResults.hasErrors()) {
				return prepareValidationErrorResponse(validationResults, 0);
			}
			NeoProfileData response = bmProfileHandler.saveBMProfile(profileForm);
			return prepareSuccessResponse(response, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<MediatorResponseModel> deleteBmProfile(@PathVariable("id") int id) {
		try {
			bmProfileHandler.deleteBmProfile(id);
			return prepareSuccessResponse("success", 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value = "/vm", method = RequestMethod.POST)
	public ResponseEntity<MediatorResponseModel> saveVmProfile(@Valid @RequestBody VmDeployForm vmProfileForm,
			BindingResult validationResults) {
		try {
			if (validationResults.hasErrors()) {
				return prepareValidationErrorResponse(validationResults, 0);
			}
			VmDeployData response = vmProfileHandler.saveVm(vmProfileForm);
			return prepareSuccessResponse(response, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value = "/bm",params={"bm_server_id"},method = RequestMethod.GET)
	public ResponseEntity<MediatorResponseModel> getAllocatedProfileList(@RequestParam("bm_server_id") Integer bmServerId) {
		try {
			List<NeoBmProfileData> list = bmProfileHandler.getAllProfileList(bmServerId);
			return prepareSuccessResponse(list, list == null?0:list.size());
		} catch (Throwable e) {
			e.printStackTrace();
			return prepareErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
	}
}
