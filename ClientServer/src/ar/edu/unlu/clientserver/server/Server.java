package ar.edu.unlu.clientserver.server;

import java.rmi.RemoteException;

public interface Server {
	public void sendMessageToClients(Object o) throws RemoteException;
}
