package ar.edu.unlu.client;

import java.rmi.RemoteException;
import java.util.Observable;

import ar.edu.unlu.server.RemoteServer;

public class ClientModel extends Observable implements RemoteClient,Client {
	private String id;
	private RemoteServer server;
	
	public ClientModel(String id) {
		this.id = id;
	}
	
	@Override
	public String getId() throws RemoteException {
		return this.id;
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
