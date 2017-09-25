package ar.edu.unlu.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteClient extends Remote{

	String getId() throws RemoteException;
	
	void message(Object o) throws RemoteException;

}
