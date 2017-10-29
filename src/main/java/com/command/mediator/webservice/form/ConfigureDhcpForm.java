package com.command.mediator.webservice.form;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ./configure-dhcp.sh <network-interface> <network> <netmask> <gateway> <startdhcp-address> <enddhcp-address>
 * @author ANIL
 *
 */
public class ConfigureDhcpForm {
	
	@JsonProperty("network_interface")
	private String networkInterface;
	
	@JsonProperty("network")
	private String network;
	
	@JsonProperty("netmask")
	private String netmask;

	@JsonProperty("gateway")
	private String gateway;
	
	@JsonProperty("startdhcp_address")
	private String startdhcpAddress;

	@JsonProperty("enddhcp_address")
	private String enddhcpAddress;

	public String getNetworkInterface() {
		return networkInterface;
	}

	public void setNetworkInterface(String networkInterface) {
		this.networkInterface = networkInterface;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public String getStartdhcpAddress() {
		return startdhcpAddress;
	}

	public void setStartdhcpAddress(String startdhcpAddress) {
		this.startdhcpAddress = startdhcpAddress;
	}

	public String getEnddhcpAddress() {
		return enddhcpAddress;
	}

	public void setEnddhcpAddress(String enddhcpAddress) {
		this.enddhcpAddress = enddhcpAddress;
	}

	@Override
	public String toString() {
		return "ConfigureDhcpForm [networkInterface=" + networkInterface + ", network=" + network + ", netmask="
				+ netmask + ", gateway=" + gateway + ", startdhcpAddress=" + startdhcpAddress + ", enddhcpAddress="
				+ enddhcpAddress + "]";
	}

}
