package ar.edu.unlu.clientserver.appserver;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

import ar.edu.unlu.clientserver.server.Server;
import ar.edu.unlu.clientserver.server.ServerFactory;

public abstract class ServerApp implements Observer{
	
	private Server server;
	//private Object lock = new Object();
	
	public ServerApp() {
		ServerFactory s = new ServerFactory(this);
		this.server = s.getServer();
	}
	
	public ServerApp(String ip,int port) {
		ServerFactory s = new ServerFactory(this,ip,port);
		this.server = s.getServer();
	}

	@Override
	public void update(Observable o, Object arg) {
		Thread actualizacionT=new Thread(){
	        @Override
	        public void run() {
	        	//synchronized (ServerApp.this.lock) {
	        		
				//}	
	        	ServerApp.this.actualizacion(arg);
	        };
	    };
	    
	    actualizacionT.start();		
	}
	
	public void sendMessageToClients(Object o) {
		try {
			this.server.sendMessageToClients(o);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract void actualizacion(Object arg);


}
