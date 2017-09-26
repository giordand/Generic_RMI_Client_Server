package ar.edu.unlu.appcliente;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

import ar.edu.unlu.client.Client;
import ar.edu.unlu.client.ClientFactory;

public abstract class ClientApp implements Observer{
	
	private Client client;
	
	public ClientApp() {
		ClientFactory c = new ClientFactory(this);
		this.client = c.getClient();
	}
	
	public ClientApp(String ip,int port,String serverIp, int serverPort) {
		ClientFactory c = new ClientFactory(this,ip,port,serverIp,serverPort);
		this.client = c.getClient();
	}
 
	@Override
	public void update(Observable o, Object arg) {
		Thread actualizacionT=new Thread(){
	        @Override
	        public void run() {
	        	ClientApp.this.actualizacion(arg);	        	
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
