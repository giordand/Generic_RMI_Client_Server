package ar.edu.unlu.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteClient extends Remote{

	final String defaultClientIp = "127.0.0.1";
	final int defaultClientPort = 9876;
	
	String getId() throws RemoteException;	
	void message(Object o) throws RemoteException;

}
