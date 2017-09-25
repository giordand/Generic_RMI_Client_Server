package ar.edu.unlu.client;

import java.rmi.RemoteException;

public interface Client {
	public void sendMessageToServer(Object o) throws RemoteException;
}
