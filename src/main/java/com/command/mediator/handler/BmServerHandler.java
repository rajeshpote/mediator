package com.command.mediator.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.cmn.CommandExecutor;
import com.command.mediator.persistent.BmServerRepository;
import com.command.mediator.persistent.NeoBmProfileRepository;
import com.command.mediator.persistent.NeoImageRepository;
import com.command.mediator.persistent.NeoProfileRepository;
import com.command.mediator.pojo.BmServerData;
import com.command.mediator.pojo.NeoBmProfileData;
import com.command.mediator.pojo.NeoImageData;
import com.command.mediator.pojo.NeoProfileData;
import com.command.mediator.util.StringUtils;
import com.command.mediator.webservice.form.AddBmServerForm;
import com.command.mediator.webservice.form.ProvisionBMServerForm;

@Service
public class BmServerHandler extends BaseHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(BmServerHandler.class);

	private String PROV_COMMAND = "./scripts/provBmServer.sh";
	
	private String STOP_SERVER_COMMAND = "./scripts/stopProvBmServer.sh";
	
	private String DEPROVISION_SERVER_COMMAND = "/home/neo/scripts/deProvBmServer.sh ";

	@Resource
	private BmServerRepository bmServerRepository;

	@Resource
	private NeoProfileRepository neoProfileRepository;

	@Resource
	private NeoBmProfileRepository neoBmProfileRepository;

	@Resource
	private CommandExecutor commandExecutor;
	
	@Resource
	private NeoImageRepository neoImageRepository;


	public BmServerData addBmServer(AddBmServerForm addBmServerForm) {
		BmServerData bmServer = createBmServerObject(addBmServerForm);
		bmServer = bmServerRepository.save(bmServer);
		//updateProjectRepository(bmServer);
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
		NeoProfileData neoProfileData = neoProfileRepository.findOne(Integer.parseInt(provisionBMProfileForm.getProfileId()));
		LOGGER.info("Loaded the neo profile : {} " + neoProfileData);
		//NeoImageData neoImageData = neoImageRepository.findOne(Integer.parseInt(neoProfileData.getImageId()));
		//LOGGER.info("Loaded the neo image : {} " + neoImageData);
		NeoBmProfileData neoBmProfileData = neoBmProfileRepository.findByNeoProfileId(neoProfileData.getId());
		LOGGER.info("Loaded the neo bm profile : {} " + neoBmProfileData);
		List<String> serverIds = provisionBMProfileForm.getServerId();
		for (String serverId : serverIds) {
			BmServerData bmServer = bmServerRepository.findOne(Integer.parseInt(serverId));
			LOGGER.info("Loaded the bm server : {} " + bmServer);
			if ("unallocated".equalsIgnoreCase(bmServer.getStatus())) {
				String output = CommandExecutor.execute(PROV_COMMAND + " " + bmServer.getName() + " " + neoProfileData.getImageId()+"-x86_64" + " " + bmServer.getPmType() + 
						" " + bmServer.getPmAddress() + " " + bmServer.getPmName() + " " + bmServer.getPmPassword() + " " + "enp1s0f1" + " " 
						+ bmServer.getInterfaceMac()+" "+neoBmProfileData.getNetType()+" "+neoBmProfileData.getDiskPartType()+" "+neoBmProfileData.getKvm());
				if (output != null && output.contains("exception on server")) {
					bmServer.setStatus("Failed to allocate:"+output);
				} else {
					bmServer.setStatus("allocated");
					bmServer = bmServerRepository.save(bmServer);
//					ProjectData projectData = projectRepository.findOne(bmServer.getProjectId());
//					int allocatedBmCount = projectData.getAllocatedBMs();
//					projectData.setAllocatedBMs(++allocatedBmCount);
//					int unAllocatedBmCount = projectData.getUnallocatedBMs();
//					projectData.setUnallocatedBMs(--unAllocatedBmCount);
//					projectRepository.save(projectData);
				}
				
			}else {
				bmServer.setStatus("Already allocated!!!");
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
		if (output != null && output.contains("exception on server"));
		return output;
	}

	public String deprovisionBmServer(String serverNames) throws Exception {
		String output = null;
		if(StringUtils.isEmpty(serverNames)){
			throw new Exception("Server name must be specified.");
		}
		String[] servers = serverNames.split(",");
		for(int i = 0 ; i < servers.length ; i++){
			output = CommandExecutor.execute(DEPROVISION_SERVER_COMMAND + servers[i]);	
		}
		if (output != null && output.contains("exception on server"));
		return output;
	}
}
