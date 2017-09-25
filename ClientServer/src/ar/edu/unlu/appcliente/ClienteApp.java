package ar.edu.unlu.appcliente;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

import ar.edu.unlu.client.Client;
import ar.edu.unlu.client.ClientFactory;

public abstract class ClienteApp implements Observer{
	private Client client;
	
	public ClienteApp() {
		ClientFactory c = new ClientFactory(this);
		this.client = c.getClient();
	}

	@Override
	public void update(Observable o, Object arg) {
		Thread actualizacionT=new Thread(){
	        @Override
	        public void run() {
	        	ClienteApp.this.actualizacion(arg);	        	
	        };
	    };
	    
	    actualizacionT.start();		
		
	}
	
	protected abstract void actualizacion(Object o);

	protected void sendMessageToServer(Object o) {
		try {
			this.client.sendMessageToServer(o);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
