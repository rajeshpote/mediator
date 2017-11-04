package com.command.mediator.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.command.mediator.persistent.BmServerRepository;
import com.command.mediator.pojo.BmServerData;
import com.command.mediator.webservice.form.AddBmServerForm;

@Service
public class BmServerHandler extends BaseHandler{
	
	private static Logger LOGGER = LoggerFactory.getLogger(BmServerHandler.class);
	
	@Resource
	private BmServerRepository bmServerRepository;

	public BmServerData addBmServer(AddBmServerForm addBmServerForm) {
		BmServerData bmServer = createBmServerObject(addBmServerForm);
		bmServer = bmServerRepository.save(bmServer);
		LOGGER.info("BM Server added: {} " + bmServer);
		return bmServer;
	}
}
