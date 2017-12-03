package com.command.mediator.handler;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.command.mediator.cmn.CommandExecutor;
import com.command.mediator.persistent.BmServerRepository;
import com.command.mediator.persistent.BmsProfileHistoryRepository;
import com.command.mediator.pojo.BmServerData;
import com.command.mediator.pojo.BmsProfileHistoryData;
import com.command.mediator.pojo.NeoBmProfileData;

@Component
public class AsyncHandler {

	private String PROV_COMMAND = "./scripts/provBmServer.sh";
	
	private static Logger LOGGER = LoggerFactory.getLogger(AsyncHandler.class);
	
	@Resource
	private BmServerRepository bmServerRepository;
	
	@Resource
	private BmsProfileHistoryRepository bmsProfileMappingRepository;

	@Async("AsyncTaskExecutor")
	public void provBmServer(BmServerData bmServer,NeoBmProfileData neoBmProfileData) {
		try {
			String output = CommandExecutor.execute(PROV_COMMAND + " " + bmServer.getName() + " " + neoBmProfileData.getImageId()+"-x86_64" + " " + bmServer.getPmType() + 
					" " + bmServer.getPmAddress() + " " + bmServer.getPmName() + " " + bmServer.getPmPassword() + " " + "enp1s0f1" + " " 
					+ bmServer.getInterfaceMac()+" "+neoBmProfileData.getNetType()+" "+neoBmProfileData.getDiskPartType()+" "+neoBmProfileData.getKvm());
			if (output != null && output.contains("exception on server")) {
				bmServer.setStatus("Failed");
				//throw new Exception("Failed to provision:"+output);
			} else {
				bmServer.setStatus("Deployed");
				saveBmsProfileHistory(bmServer.getId(), neoBmProfileData.getId());
			}
		bmServer = bmServerRepository.save(bmServer);
		} catch (Throwable e) {
			LOGGER.error("Error while publishing msg to oka:{}", e);
			e.printStackTrace();
		}
	}
	
	private void saveBmsProfileHistory(Integer bmServreId, Integer profileId){
		BmsProfileHistoryData mappingData = new BmsProfileHistoryData();
		mappingData.setBmServerId(bmServreId);
		mappingData.setProfileId(profileId);
		mappingData.setAllocationDate(new Date());
		bmsProfileMappingRepository.save(mappingData);
	}


}
