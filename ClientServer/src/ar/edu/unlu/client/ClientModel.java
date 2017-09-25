package ar.edu.unlu.client;

import java.rmi.RemoteException;
import java.util.Observable;

import ar.edu.unlu.server.RemoteServer;

public class ClientModel extends Observable implements RemoteClient,Client {
	private String id;
	private String ip;
	private int port;
	private RemoteServer server;
	
	public ClientModel(String id) {
		this(id,"",-1);
	}
	
	public ClientModel(String id,String ip , int port) {
		this.id = id;
		this.ip = ip;
		this.port = port;
	}
	
	@Override
	public String getId() throws RemoteException {
		return this.id;
	}
	
	public int getPort() {
		return port;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setServerModel(RemoteServer s) {
		this.server = s;
	}

	@Override
	public void message(Object o) throws RemoteException {
		this.setChanged();
		this.notifyObservers(o);
	}

	@Override
	public void sendMessageToServer(Object o) throws RemoteException {
		this.server.message(o);
		
	}
	
	
}
