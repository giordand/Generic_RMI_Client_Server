package ar.edu.unlu.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observer;

import ar.edu.unlu.server.RemoteServer;



public class ClientFactory{
	
	private String ip;
	private int port;
	private ClientModel clientModel;
	private Observer observador;

	
	public ClientFactory(Observer clienteApp){
		this(clienteApp,"127.0.0.1",9876);
	}
	public ClientFactory(Observer clienteApp,String ip, int port){
		this.ip = ip;
		this.port = port;
		this.observador = clienteApp;
		connectServer(); 	 			 
	}
	
	public Client getClient() {
		return this.clientModel;
	}

	private void connectServer() {
		try{ 								
			
			//Deberia poder parametrizarse
			String serverIp = "127.0.0.1";
			int serverPort = 7896;
			
			//Me conecto al servidor
			Registry registro=LocateRegistry.getRegistry(serverIp, serverPort);
			RemoteServer server = (RemoteServer)registro.lookup("ServerPOO");
			System.out.println("Conectado al server");
			//Creo el server del cliente
			createServer();
						
		
			/*
			 * Le pido al servidor (juego) que me agregue como cliente. Le paso mi IP y PORT para que
			 * se conecte a mi server
			 */			
			server.register(this.ip ,this.port);
			this.clientModel.setServerModel(server);
			
		}catch(Exception ex){
			System.out.println(ex);
		}
		
	}
	private void createServer() {	
		try{
			 System.setProperty("java.rmi.server.hostname", this.ip);
			 Registry registro = LocateRegistry.createRegistry(this.port);
			 this.clientModel = new ClientModel("Cliente1");
			 this.clientModel.addObserver(this.observador);
			 RemoteClient remoteClientModel = (RemoteClient) UnicastRemoteObject.exportObject(this.clientModel, port);
	         registro.bind("ClientePOO", remoteClientModel);
	        
	         System.out.println("Usted esta hosteando con la IP :" + this.ip + "-- Puerto: "+ this.port);	     
	         
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}
	}
	
}
