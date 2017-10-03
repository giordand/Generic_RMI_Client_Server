package ar.edu.unlu.clientserver.client;

import java.rmi.RemoteException;

public interface Client {
	public void sendMessageToServer(Object o) throws RemoteException;
}
