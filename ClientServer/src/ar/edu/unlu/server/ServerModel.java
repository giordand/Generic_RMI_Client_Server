package ar.edu.unlu.server;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Observable;

import ar.edu.unlu.client.IClientModel;

public class ServerModel extends Observable implements IServerModel{
    
	private ArrayList<IClientModel> clientes;
	
	protected ServerModel() throws RemoteException{
		this.clientes = new ArrayList<IClientModel>();
	}


	@Override
	public void register(String ip, int port) throws RemoteException {
		Registry registro;
		try {
			System.out.println(ip);
			System.out.println(port);
			
			registro = LocateRegistry.getRegistry(ip, port);
			IClientModel cliente =(IClientModel)registro.lookup("ClientePOO");
			clientes.add(cliente);
			//this.notifyThread();
			this.setChanged();
    		this.notifyObservers("Nuevo cliente conectado = "+cliente.getId());
			System.out.println("El modelo del servidor registro un nuevo cliente");
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	    
	}
		
} 
