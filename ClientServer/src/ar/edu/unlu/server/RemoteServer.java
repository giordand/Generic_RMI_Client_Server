package ar.edu.unlu.server;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteServer extends Remote {
		void register(String ip, int port) throws RemoteException;
		void message(Object o) throws RemoteException;
}
