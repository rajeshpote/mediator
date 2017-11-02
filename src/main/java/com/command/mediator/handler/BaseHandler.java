package com.command.mediator.handler;

import org.springframework.util.StringUtils;

import com.command.mediator.webservice.form.ConfigureDhcpForm;
import com.command.mediator.webservice.form.CreateBareMetalServerForm;

public class BaseHandler {

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

}