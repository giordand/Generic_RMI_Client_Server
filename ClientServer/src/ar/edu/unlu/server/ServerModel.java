package ar.edu.unlu.server;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Observable;

import ar.edu.unlu.client.RemoteClient;

public class ServerModel extends Observable implements RemoteServer,Server{
    
	private ArrayList<RemoteClient> clientes;
	
	protected ServerModel() throws RemoteException{
		this.clientes = new ArrayList<RemoteClient>();
	}


	@Override
	public void register(String ip, int port) throws RemoteException {
		Registry registro;
		try {
			System.out.println(ip);
			System.out.println(port);
			
			registro = LocateRegistry.getRegistry(ip, port);
			RemoteClient cliente =(RemoteClient)registro.lookup("ClientePOO");
			clientes.add(cliente);
			this.setChanged();
    		this.notifyObservers("Nuevo cliente conectado = "+cliente.getId());
			System.out.println("El modelo del servidor registro un nuevo cliente");
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}		
	    
	}
	
	@Override
	public void message(Object o) throws RemoteException {
		this.setChanged();
		this.notifyObservers(o);
	}
	
	
	public void sendMessageToClients(Object o) throws RemoteException {
		for (RemoteClient c : this.clientes) {
			c.message(o);
		}
	}
		
} 
