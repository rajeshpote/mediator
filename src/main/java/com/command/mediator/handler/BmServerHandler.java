package com.command.mediator.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.cmn.CommandExecutor;
import com.command.mediator.persistent.BmServerRepository;
import com.command.mediator.persistent.NeoBmProfileRepository;
import com.command.mediator.persistent.NeoProfileRepository;
import com.command.mediator.pojo.BmServerData;
import com.command.mediator.pojo.NeoBmProfileData;
import com.command.mediator.pojo.NeoProfileData;
import com.command.mediator.webservice.form.AddBmServerForm;
import com.command.mediator.webservice.form.ProvisionBMServerForm;

@Service
public class BmServerHandler extends BaseHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(BmServerHandler.class);

	private String PROV_COMMAND = "./scripts/provBmServer.sh";

	@Resource
	private BmServerRepository bmServerRepository;

	@Resource
	private NeoProfileRepository neoProfileRepository;

	@Resource
	private NeoBmProfileRepository neoBmProfileRepository;

	@Resource
	private CommandExecutor commandExecutor;

	// @Resource
	// private ProvisionBmServer provisionBmServer;

	public BmServerData addBmServer(AddBmServerForm addBmServerForm) {
		BmServerData bmServer = createBmServerObject(addBmServerForm);
		bmServer = bmServerRepository.save(bmServer);
		LOGGER.info("BM Server added: {} " + bmServer);
		return bmServer;
	}

	public List<BmServerData> getBmServer() {
		List<BmServerData> bmServerList = (List<BmServerData>) bmServerRepository.findAll();
		LOGGER.info("BM Server found: {} " + bmServerList);
		return bmServerList;
	}

	public List<BmServerData> provisionBmServer(ProvisionBMServerForm provisionBMProfileForm) {
		LOGGER.info("BM Server provision request: {} " + provisionBMProfileForm);
		List<BmServerData> bmServerDataList = new ArrayList<BmServerData>();
		NeoProfileData neoProfileData = neoProfileRepository.findOne(Integer.parseInt(provisionBMProfileForm.getProfileId()));
		LOGGER.info("Loaded the neo profile : {} " + neoProfileData);
		NeoBmProfileData neoBmProfileData = neoBmProfileRepository.findByNeoProfileId(neoProfileData.getId());
		LOGGER.info("Loaded the neo bm profile : {} " + neoBmProfileData);
		List<String> serverIds = provisionBMProfileForm.getServerId();
		for (String serverId : serverIds) {
			BmServerData bmServer = bmServerRepository.findOne(Integer.parseInt(serverId));
			LOGGER.info("Loaded the bm server : {} " + bmServer);
			if ("unallocated".equalsIgnoreCase(bmServer.getStatus())) {
				String output = CommandExecutor.execute(PROV_COMMAND + " " + bmServer.getName() + " " + neoProfileData.getName() + " " + bmServer.getPmType() + 
						" " + bmServer.getPmAddress() + " " + bmServer.getPmName() + " " + bmServer.getPmAddress() + " " + "enp1s0f1" + " " 
						+ bmServer.getInterfaceMac() + " " + neoProfileData.getKickstartFile());
				if (output != null && output.contains("exception on server")) {
					bmServer.setStatus("Failed to allocate:"+output);
				} else {
					bmServer.setStatus("allocated");
					bmServer = bmServerRepository.save(bmServer);
				}
				
			}else {
				bmServer.setStatus("Already allocated!!!");
			}
			bmServerDataList.add(bmServer);
		}
		return bmServerDataList;
	}

}
