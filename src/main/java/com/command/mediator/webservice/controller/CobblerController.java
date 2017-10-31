package com.command.mediator.webservice.controller;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.IssuerSerialNumRequest;

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

import com.command.mediator.handler.CobblerHandler;
import com.command.mediator.pojo.CobblerResponse;
import com.command.mediator.pojo.BmResponse;
import com.command.mediator.webservice.form.CreateBareMetalServerForm;
import com.command.mediator.webservice.form.ProfileForm;
import com.command.mediator.webservice.form.ConfigureDhcpForm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/mediator/v1/cobbler", consumes = "application/json", produces = "application/json")
public class CobblerController extends BaseController {

	private static Logger LOGGER = LoggerFactory.getLogger(CobblerController.class);

	@Resource
	private CobblerHandler cobblerHandler;

	@RequestMapping(value = "/kickstart", method = RequestMethod.GET)
	public ResponseEntity<CobblerResponse> getKickstartFiles() {
		try {
			CobblerResponse response = cobblerHandler.getKickStartFiles();
			return new ResponseEntity<CobblerResponse>(response, HttpStatus.OK);
		} catch (Throwable t) {
			return new ResponseEntity<CobblerResponse>(new CobblerResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ResponseEntity<CobblerResponse> getCobblerProfiles() {
		try {
			CobblerResponse response = cobblerHandler.getCobblerProfiles();
			return new ResponseEntity<CobblerResponse>(response, HttpStatus.OK);
		} catch (Throwable t) {
			return new ResponseEntity<CobblerResponse>(new CobblerResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/server", method = RequestMethod.POST)
	public ResponseEntity<BmResponse> createBareMetalServer(@RequestBody CreateBareMetalServerForm serverForm) {
		try {
			LOGGER.info("Input server form : {}", serverForm);
			BmResponse response = cobblerHandler.createBareMetalServer(serverForm);
			return new ResponseEntity<BmResponse>(response,
					response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Throwable t) {
			return new ResponseEntity<BmResponse>(new BmResponse(false, t.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/configure_dhcp", method = RequestMethod.POST)
	public ResponseEntity<BmResponse> configureDHCPServer(@RequestBody ConfigureDhcpForm configureDhcpForm) {
		try {
			LOGGER.info("Input Dhcp form : {}", configureDhcpForm);
			BmResponse response = cobblerHandler.configureDhcpServer(configureDhcpForm);
			return new ResponseEntity<BmResponse>(response,
					response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Throwable t) {
			return new ResponseEntity<BmResponse>(new BmResponse(false, t.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/image" , method = RequestMethod.POST)
	public ResponseEntity<BmResponse> uploadImage(@RequestBody String fileName){
		BmResponse response = cobblerHandler.uploadImage(fileName);
		return new ResponseEntity<BmResponse>(response,
				response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/image" , method = RequestMethod.GET)
	public ResponseEntity<BmResponse> getImageList(){
		BmResponse response = cobblerHandler.getImageList();
		return new ResponseEntity<BmResponse>(response,
				response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/bm_profile" , method = RequestMethod.POST)
	public ResponseEntity<BmResponse> saveBMProfile(@RequestBody ProfileForm profileForm){
		BmResponse response = cobblerHandler.saveBMProfile(profileForm);
		return new ResponseEntity<BmResponse>(response,
				response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/vm_profile" , method = RequestMethod.POST)
	public ResponseEntity<BmResponse> saveVMProfile(@RequestBody ProfileForm profileForm){
		BmResponse response = cobblerHandler.saveVMProfile(profileForm);
		return new ResponseEntity<BmResponse>(response,
				response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/vm_group_profile" , method = RequestMethod.POST)
	public ResponseEntity<BmResponse> saveVMGroupProfile(@RequestBody ProfileForm profileForm){
		BmResponse response = cobblerHandler.saveVMGroupProfile(profileForm);
		return new ResponseEntity<BmResponse>(response,
				response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "profile_list" , method = RequestMethod.GET)
	public ResponseEntity<BmResponse> getProfileList(){
		BmResponse response = cobblerHandler.getProfileList();
		return new ResponseEntity<BmResponse>(response,
				response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "bm_server_list" , method = RequestMethod.GET)
	public ResponseEntity<BmResponse> getBareMetalServerList(){
		BmResponse response = cobblerHandler.getBareMetalServerList();
		return new ResponseEntity<BmResponse>(response,
				response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "bm_bridge" , method = RequestMethod.GET)
	public ResponseEntity<BmResponse> getBMBridge(@RequestParam (value="server_name", required=true) String serverName){
		BmResponse response = cobblerHandler.getBMBridge(serverName);
		return new ResponseEntity<BmResponse>(response,
				response.isSuccess() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
