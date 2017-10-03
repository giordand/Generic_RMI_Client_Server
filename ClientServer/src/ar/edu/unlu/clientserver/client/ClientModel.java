package ar.edu.unlu.clientserver.client;

import java.rmi.RemoteException;
import java.util.Observable;

import ar.edu.unlu.clientserver.server.RemoteServer;

public class ClientModel extends Observable implements RemoteClient,Client {
	private String id;
	private RemoteServer server;
	
	protected ClientModel(String id) {
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
