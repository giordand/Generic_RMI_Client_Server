package ar.edu.unlu.server;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import ar.edu.unlu.client.IClientModel;

public class ServerModel implements IServerModel{
    
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
			System.out.println("Conectado al cliente"+cliente.getId());
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
} 
