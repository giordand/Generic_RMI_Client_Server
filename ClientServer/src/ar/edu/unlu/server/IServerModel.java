package ar.edu.unlu.server;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServerModel extends Remote {
		void register(String ip, int port) throws RemoteException;
}
