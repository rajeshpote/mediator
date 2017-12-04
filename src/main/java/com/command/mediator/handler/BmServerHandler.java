package com.command.mediator.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.cmn.CommandExecutor;
import com.command.mediator.persistent.BmServerRepository;
import com.command.mediator.persistent.BmsProfileHistoryRepository;
import com.command.mediator.persistent.NeoBmProfileRepository;
import com.command.mediator.persistent.NeoImageRepository;
import com.command.mediator.pojo.BmServerData;
import com.command.mediator.pojo.BmsProfileHistoryData;
import com.command.mediator.pojo.NeoBmProfileData;
import com.command.mediator.util.StringUtils;
import com.command.mediator.webservice.form.AddBmServerForm;
import com.command.mediator.webservice.form.ProvisionBMServerForm;

@Service
public class BmServerHandler extends BaseHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(BmServerHandler.class);

	private String STOP_SERVER_COMMAND = "/home/neo/scripts/stopProvBmServer.sh";
	
	private String DEPROVISION_SERVER_COMMAND = "/home/neo/scripts/deProvBmServer.sh ";

	@Resource
	private BmServerRepository bmServerRepository;

	@Resource
	private NeoBmProfileRepository neoBmProfileRepository;

	@Resource
	private CommandExecutor commandExecutor;
	
	@Resource
	private NeoImageRepository neoImageRepository;
	
	@Resource
	private AsyncHandler asyncHandler;
	

	public BmServerData addBmServer(AddBmServerForm addBmServerForm) {
		BmServerData bmServer = createBmServerObject(addBmServerForm);
		bmServer = bmServerRepository.save(bmServer);
		LOGGER.info("BM Server added: {} " + bmServer);
		return bmServer;
	}
	
	public List<BmServerData> getBmServer() {
		List<BmServerData> bmServerList = (List<BmServerData>) bmServerRepository.findAll();
		Collections.sort(bmServerList);
		LOGGER.info("BM Server found: {} " + bmServerList);
		return bmServerList;
	}

	public List<BmServerData> provisionBmServer(ProvisionBMServerForm provisionBMProfileForm) {
		LOGGER.info("BM Server provision request: {} " + provisionBMProfileForm);
		List<BmServerData> bmServerDataList = new ArrayList<BmServerData>();
		NeoBmProfileData neoBmProfileData = neoBmProfileRepository.findOne(Integer.parseInt(provisionBMProfileForm.getProfileId()));
		LOGGER.info("Loaded the neo bm profile : {} " + neoBmProfileData);
		List<String> serverIds = provisionBMProfileForm.getServerId();
		for (String serverId : serverIds) {
			BmServerData bmServer = bmServerRepository.findOne(Integer.parseInt(serverId));
			LOGGER.info("Loaded the bm server : {} " + bmServer);
			if ("Failed".equalsIgnoreCase(bmServer.getStatus()) || "Free".equalsIgnoreCase(bmServer.getStatus())) {
				// Async call
				asyncHandler.provBmServer(bmServer, neoBmProfileData);
			} else {
				bmServer.setStatus("This BM Server is not free right now");
			}
			bmServerDataList.add(bmServer);
		}
		return bmServerDataList;
	}

	public BmServerData updateBmServer(String id, AddBmServerForm addBmServerForm) throws Exception {
		BmServerData bmServer = bmServerRepository.findOne(Integer.valueOf(id));
		if(Objects.isNull(bmServer)){
			throw new Exception("BM Sever not present with the given id.");
		}
		bmServer = updateBmServer(bmServer, addBmServerForm);
		bmServer = bmServerRepository.save(bmServer);
		LOGGER.info("Updated bm successfully:{}",bmServer);
		return bmServer;
	}

	public void deleteBmServer(int id) {
		bmServerRepository.delete(id);
		LOGGER.info("Deleted bm server for id : {} ");
	}
	
	public String stopBmServer(String serverName) throws Exception{
		String output = null;
		if(StringUtils.isEmpty(serverName)){
			throw new Exception("Server name must be specified.");
		}
		output = CommandExecutor.execute(STOP_SERVER_COMMAND + " " + serverName);
		return output;
	}

	public String deprovisionBmServer(String serverNames) throws Exception {
		String output = null;
		if(StringUtils.isEmpty(serverNames)){
			throw new Exception("Server name must be specified.");
		}
		String[] servers = serverNames.split(",");
		for (int i = 0; i < servers.length; i++) {
			output = CommandExecutor.execute(DEPROVISION_SERVER_COMMAND + servers[i]);
			if (output != null && !output.contains("exception on server")) {
				BmServerData bmServer = bmServerRepository.findByName(servers[i]);
				bmServer.setStatus("Free");
				bmServerRepository.save(bmServer);
			}
		}
		return output;
	}

	public BmServerData getBmServer(String id) {
		BmServerData bmServer = bmServerRepository.findOne(Integer.parseInt(id));
		LOGGER.info("BM Server found: {} " + bmServer);
		return bmServer;
	}
	
	public BmServerData updateBm(String bmName, String assignedIp, String status, String cpu, String memory,
			String logpath, String username, String password) {
		BmServerData savedBmServer = bmServerRepository.findByName(bmName);
		savedBmServer = updateSavedBm(savedBmServer,assignedIp,status,cpu,memory,logpath,username,password);
		bmServerRepository.save(savedBmServer);
		return savedBmServer;
	}
}
