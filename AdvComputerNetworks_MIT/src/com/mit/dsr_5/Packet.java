package com.mit.dsr_5;

import java.util.LinkedHashSet;

public class Packet {

	String packetType;
	String srcIP;
	int UID;
	String destIP; // Destination
	LinkedHashSet<String> route = new LinkedHashSet<String>();


	public Packet(String packetType, String srcIP, int uID, String destIP, String path) {
		super();
		this.packetType = packetType;
		this.srcIP = srcIP;
		this.UID = uID;
		this.destIP = destIP;
		this.route.add(path);
	}

	public Packet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Packet(Packet p) {
		super();
		this.packetType = p.packetType;
		this.srcIP = p.srcIP;
		this.UID = p.UID;
		this.destIP = p.destIP;
		this.route.addAll(p.route);
	}

	public void addRoute(String route) {
		this.route.add(route);
	}

	public void setPacketType(String packetType)
	{
		this.packetType = packetType;
	}

	public String getDestIP() {
		return destIP;
		
		
	}

	@Override
	public String toString() {
		return "Packet [packetType=" + packetType + ", srcIP=" + srcIP + ", UID=" + UID + ", destIP=" + destIP
				+ ", route=" + route + "]";
	}

}