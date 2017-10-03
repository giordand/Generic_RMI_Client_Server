package ar.edu.unlu.clientserver.server;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteServer extends Remote {
		final String defaultServerIp = "127.0.0.1";
		final int defaultServerPort = 9999;
		void register(String ip, int port) throws RemoteException;
		void message(Object o) throws RemoteException;
}
