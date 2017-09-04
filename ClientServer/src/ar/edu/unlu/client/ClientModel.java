package ar.edu.unlu.client;

public class ClientModel implements IClientModel {
	private String id;
	private String ip;
	private int port;
	
	public ClientModel(String id) {
		this(id,"",-1);
	}
	
	public ClientModel(String id,String ip , int port) {
		this.id = id;
		this.ip = ip;
		this.port = port;
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	public int getPort() {
		return port;
	}
	
	public String getIp() {
		return ip;
	}
}
