package com.command.mediator.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;
import com.command.mediator.pojo.BmServerData;
import com.command.mediator.pojo.NeoBmProfileData;
import com.command.mediator.pojo.NeoImageData;
import com.command.mediator.pojo.NeoProfileData;
import com.command.mediator.pojo.NetworkInfo;
import com.command.mediator.pojo.PartitioningInfo;
import com.command.mediator.pojo.ProjectData;
import com.command.mediator.pojo.StorageInfo;
import com.command.mediator.pojo.VmDeployData;
import com.command.mediator.webservice.form.AddBmServerForm;
import com.command.mediator.webservice.form.BmProfileForm;
import com.command.mediator.webservice.form.ConfigureDhcpForm;
import com.command.mediator.webservice.form.CreateBareMetalServerForm;
import com.command.mediator.webservice.form.NeoImageForm;
import com.command.mediator.webservice.form.NetworkInfoForm;
import com.command.mediator.webservice.form.PartitioningInfoForm;
import com.command.mediator.webservice.form.ProjectForm;
import com.command.mediator.webservice.form.StorageInfoForm;
import com.command.mediator.webservice.form.VmDeployForm;

public class BaseHandler {
	
	private String DEPLOY_VM_COMMAND = "/home/neo/scripts/vm-deploy_iso.sh ";
	
	protected String getVmDeployCommand(VmDeployForm vmDeployForm) {
		StringBuilder command = new StringBuilder(DEPLOY_VM_COMMAND);
		command.append(vmDeployForm.getIpAddress()).append(" ")
		.append(vmDeployForm.getUserName()).append(" ")
		.append(vmDeployForm.getPassword()).append(" ")
		.append(vmDeployForm.getVmName()).append(" ")
		.append(vmDeployForm.getRam()).append(" ")
		.append(vmDeployForm.getCpus()).append(" ")
		.append(vmDeployForm.getStorage()).append(" ");
		return command.toString();
	}

	public String getDhcpCommand(ConfigureDhcpForm configureDhcpForm) {
		StringBuilder dhcpCommand = new StringBuilder("./configure-dhcp.sh");
		if(!StringUtils.isEmpty(configureDhcpForm.getNetworkInterface()))	
			dhcpCommand.append(" ").append(configureDhcpForm.getNetworkInterface());
		if(!StringUtils.isEmpty(configureDhcpForm.getNetwork()))
			dhcpCommand.append(" ").append(configureDhcpForm.getNetwork());
		if(!StringUtils.isEmpty(configureDhcpForm.getNetmask()))
			dhcpCommand.append(" ").append(configureDhcpForm.getNetmask());
		if(!StringUtils.isEmpty(configureDhcpForm.getGateway()))
			dhcpCommand.append(" ").append(configureDhcpForm.getGateway());
		if(!StringUtils.isEmpty(configureDhcpForm.getStartdhcpAddress()))
			dhcpCommand.append(" ").append(configureDhcpForm.getStartdhcpAddress());
		if(!StringUtils.isEmpty(configureDhcpForm.getEnddhcpAddress()))
			dhcpCommand.append(" ").append(configureDhcpForm.getEnddhcpAddress());
		return dhcpCommand.toString();
	}

	public String getAddCobblerCommand(CreateBareMetalServerForm serverForm) {
		StringBuilder addCobblercommand = new StringBuilder("cobbler system add");
		if(!StringUtils.isEmpty(serverForm.getName()))
			addCobblercommand.append(" --name=").append("\"").append(serverForm.getName()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getHostname()))
			addCobblercommand.append(" --hostname=").append("\"").append(serverForm.getHostname()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getCobblerProfile()))
			addCobblercommand.append(" --profile=").append("\"").append(serverForm.getCobblerProfile()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getStatus()))
			addCobblercommand.append(" --status=").append("\"").append(serverForm.getStatus()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getKernelOptions()))
			addCobblercommand.append(" --kopts=").append("\"").append(serverForm.getKernelOptions()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getKernelOptionsPost()))
			addCobblercommand.append(" --kopts-post=").append("\"").append(serverForm.getKernelOptionsPost()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getKickstartMetaData()))
			addCobblercommand.append(" --ksmeta=").append("\"").append(serverForm.getKickstartMetaData()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getNetbootEnabled()))
			addCobblercommand.append(" --netboot-enabled=").append("\"").append(serverForm.getNetbootEnabled()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getKickstartFile()))
			addCobblercommand.append(" --kickstart=").append("\"").append(serverForm.getKickstartFile()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getComment()))
			addCobblercommand.append(" --comment=").append("\"").append(serverForm.getComment()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getPowerManagement()))
			addCobblercommand.append(" --power-type=").append("\"").append(serverForm.getPowerManagement()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getPowerManagementAddress()))
			addCobblercommand.append(" --power-address=").append("\"").append(serverForm.getPowerManagementAddress()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getUsername()))
			addCobblercommand.append(" --power-user=").append("\"").append(serverForm.getUsername()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getPassword()))
			addCobblercommand.append(" --power-pass=").append("\"").append(serverForm.getPassword()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getMacAddress()))
			addCobblercommand.append(" --mac-address=").append("\"").append(serverForm.getMacAddress()).append("\"");
		if(!StringUtils.isEmpty(serverForm.getServerInterface()))
			addCobblercommand.append(" --interface=").append("\"").append(serverForm.getServerInterface()).append("\"");
		
		return addCobblercommand.toString();
	}
	
	public NeoProfileData createBmProfileObject(BmProfileForm profileForm){
		NeoProfileData bmProfile = new NeoProfileData();
		bmProfile.setName(profileForm.getName());
		bmProfile.setDescription(profileForm.getDescription());
		bmProfile.setImageId(profileForm.getImageId());
		//bmProfile.setKickstartFile(profileForm.getKickstartFile());
		bmProfile.setCreatedBy(profileForm.getCreatedBy());
		bmProfile.setCreatedOn(new Date());
		return bmProfile;
	}
	
	public NeoBmProfileData createBmNeoProfileObject(BmProfileForm profileForm, Integer neoProfileId){
		NeoBmProfileData neoBmProfile = new NeoBmProfileData();
		List<PartitioningInfo> partitioningList = new ArrayList<PartitioningInfo>();
		List<NetworkInfo> networkInfoList = new ArrayList<NetworkInfo>();
		neoBmProfile.setNeoProfileId(neoProfileId);
		neoBmProfile.setImageId(profileForm.getImageId());
		neoBmProfile.setKvm(profileForm.getKvm());
		neoBmProfile.setDiskPartType(profileForm.getDiskPartType());
		neoBmProfile.setNetType(profileForm.getNetType());
		if(!profileForm.getPackages().isEmpty()){
			String packages = StringUtils.arrayToDelimitedString(profileForm.getPackages().toArray(), ",");
			neoBmProfile.setPackages(packages);
		}
		for (PartitioningInfoForm partitioningInfoForm : profileForm.getPartitioningInfo()) {
			PartitioningInfo partitioningInfo = createPartitioningInfoObject(partitioningInfoForm);
			partitioningList.add(partitioningInfo);
		}
		neoBmProfile.setPartitioningInfo(partitioningList);
		for (NetworkInfoForm networkInfoForm : profileForm.getNetworkInfo()) {
			NetworkInfo networkInfo = createNetworkInfoObject(networkInfoForm);
			networkInfoList.add(networkInfo);
		}
		neoBmProfile.setNetworkInfo(networkInfoList);
		return neoBmProfile;
	}
	
	public PartitioningInfo createPartitioningInfoObject(PartitioningInfoForm partitioningInfoForm){
		PartitioningInfo partitioningInfo = new PartitioningInfo();
		partitioningInfo.setDisk(partitioningInfoForm.getDisk());
		partitioningInfo.setPartitionType(partitioningInfoForm.getPartitionType());
		partitioningInfo.setStoragePercentage(partitioningInfoForm.getStoragePercentage());
		partitioningInfo.setMountPath(partitioningInfoForm.getMountPath());
		return partitioningInfo;
	}
	
	public NetworkInfo createNetworkInfoObject(NetworkInfoForm networkInfoForm){
		NetworkInfo networkInfo = new NetworkInfo();
		networkInfo.setDevice(networkInfoForm.getDevice());
		networkInfo.setBridgeName(networkInfoForm.getBridgeName());
		networkInfo.setBootProtocol(networkInfoForm.getBootProtocol());
		networkInfo.setIp(networkInfoForm.getIp());
		networkInfo.setNetmask(networkInfoForm.getNetmask());
		networkInfo.setNic(networkInfoForm.getNic());
		return networkInfo;
	}
	
	public NeoImageData createImageObject(NeoImageForm neoImageForm){
		NeoImageData neoImage = new NeoImageData();
		neoImage.setImageName(neoImageForm.getImageName());
		neoImage.setDescription(neoImageForm.getDescription());
		neoImage.setOsType(neoImageForm.getOsType());
		neoImage.setMountPath("/mnt/neo");
		neoImage.setIsoPath("/home/neo/iso-images/");
		return neoImage;
	}

	public BmServerData createBmServerObject(AddBmServerForm addBmServerForm) {
		BmServerData bmServer = new BmServerData();
		bmServer.setName(addBmServerForm.getName());
		bmServer.setInterfaceMac(addBmServerForm.getInterfaceMac());
		bmServer.setPmName(addBmServerForm.getPmName());
		bmServer.setPmAddress(addBmServerForm.getPmAddress());
		bmServer.setPmType(addBmServerForm.getPmType());
		bmServer.setPmPassword(addBmServerForm.getPmPassword());
		bmServer.setProjectId(addBmServerForm.getProjectId());
		bmServer.setCreatedDate(new Date());
		bmServer.setStatus("unallocated");
		if(addBmServerForm.getNetworks() != null){
			bmServer.setNetworks(addBmServerForm.getNetworks());
		}
		if(addBmServerForm.getDisks()!= null){
			bmServer.setDisks(addBmServerForm.getDisks());
		}
		return bmServer;
	}
	
	public ProjectData createPojectObject(ProjectForm projectForm) {
		ProjectData projectData = new ProjectData();
		projectData.setProjectNane(projectForm.getProjectNane());
		projectData.setDepartment(projectForm.getDepartment());
		projectData.setProjectDescription(projectForm.getProjectDescription());
		return projectData;
	}
	
	public BmServerData updateBmServer(BmServerData bmServer, AddBmServerForm addBmServerForm) {
		if (!StringUtils.isEmpty(addBmServerForm.getName())) {
			bmServer.setName(addBmServerForm.getName());
		}
		if (!StringUtils.isEmpty(addBmServerForm.getInterfaceMac())) {
			bmServer.setInterfaceMac(addBmServerForm.getInterfaceMac());
		}
		if (!StringUtils.isEmpty(addBmServerForm.getPmAddress())) {
			bmServer.setPmAddress(addBmServerForm.getPmAddress());
		}
		if (!StringUtils.isEmpty(addBmServerForm.getPmName())) {
			bmServer.setPmName(addBmServerForm.getPmName());
		}
		if (!StringUtils.isEmpty(addBmServerForm.getPmPassword())) {
			bmServer.setPmPassword(addBmServerForm.getPmPassword());
		}
		if (!StringUtils.isEmpty(addBmServerForm.getPmType())) {
			bmServer.setPmType(addBmServerForm.getPmType());
		}
		if (addBmServerForm.getProjectId() != null) {
			bmServer.setProjectId(addBmServerForm.getProjectId());
		}
		return bmServer;
	}
	
	public VmDeployData createVmProfile(VmDeployForm vmProfileForm) {
		VmDeployData vmProfile = new VmDeployData();
		vmProfile.setIpAddress(vmProfileForm.getIpAddress());
		vmProfile.setUserName(vmProfileForm.getUserName());
		vmProfile.setPassword(vmProfileForm.getPassword());
		vmProfile.setVmName(vmProfileForm.getVmName());
		vmProfile.setCpus(vmProfileForm.getCpus());
		vmProfile.setRam(vmProfileForm.getRam());
		vmProfile.setStorage(vmProfileForm.getStorage());
		return vmProfile;
	}

	public StorageInfo createStorageInfoObject(StorageInfoForm storageInfoForm){
		StorageInfo storageInfo = new StorageInfo();
		storageInfo.setDisk(storageInfoForm.getDisk());
		storageInfo.setSpacePercentage(storageInfoForm.getSpacePercentage());
		storageInfo.setMountPath(storageInfoForm.getMountPath());
		return storageInfo;
	}

}
