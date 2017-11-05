package com.command.mediator.handler;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.command.mediator.persistent.BmServerRepository;
import com.command.mediator.pojo.BmResponse;
import com.command.mediator.pojo.BmServerData;
import com.command.mediator.pojo.ProvisionBmServerData;
import com.command.mediator.webservice.form.AddBmServerForm;
import com.command.mediator.webservice.form.ProvisionBMServerForm;

@Service
public class BmServerHandler extends BaseHandler{
	
	private static Logger LOGGER = LoggerFactory.getLogger(BmServerHandler.class);
	
	@Resource
	private BmServerRepository bmServerRepository;
	
	//@Resource
	//private ProvisionBmServer provisionBmServer;

	public BmServerData addBmServer(AddBmServerForm addBmServerForm) {
		BmServerData bmServer = createBmServerObject(addBmServerForm);
		bmServer = bmServerRepository.save(bmServer);
		LOGGER.info("BM Server added: {} " + bmServer);
		return bmServer;
	}

	public List<BmServerData> getBmServer() {
		List<BmServerData> bmServerList = (List<BmServerData>) bmServerRepository.findAll();
		LOGGER.info("BM Server added: {} " + bmServerList);
		return bmServerList;
	}

	public ProvisionBmServerData provisionBmServer(ProvisionBMServerForm provisionBMProfileForm) {
		ProvisionBmServerData provisionBmServerData = bmServerProvision(provisionBMProfileForm);
		
		return provisionBmServerData;
	}

	
}
