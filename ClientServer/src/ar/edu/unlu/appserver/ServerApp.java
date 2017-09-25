package ar.edu.unlu.appserver;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

import ar.edu.unlu.server.Server;
import ar.edu.unlu.server.ServerFactory;

public abstract class ServerApp implements Observer{
	
	private Server server;
	
	public ServerApp() {
		ServerFactory s = new ServerFactory(this);
		this.server = s.getServerModel();
	}

	@Override
	public void update(Observable o, Object arg) {
		Thread actualizacionT=new Thread(){
	        @Override
	        public void run() {
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
