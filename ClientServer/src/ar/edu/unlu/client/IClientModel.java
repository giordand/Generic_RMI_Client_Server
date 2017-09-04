package ar.edu.unlu.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClientModel extends Remote{

	String getId() throws RemoteException;

}
