package ar.edu.unlu.clientserver.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observer;

import ar.edu.unlu.clientserver.server.RemoteServer;



public class ClientFactory{
	
	private static int nextClient = 0;
	private String ip;
	private int port;
	private String idCliente;
	private ClientModel clientModel;
	private Observer observador;

	
	public ClientFactory(Observer clienteApp){
		this(clienteApp,RemoteClient.defaultClientIp,RemoteClient.defaultClientPort,RemoteServer.defaultServerIp,RemoteServer.defaultServerPort);
	}
	public ClientFactory(Observer clienteApp,String ip, int port,String serverIp,int serverPort){
		this.ip = ip;
		this.port = port;
		this.observador = clienteApp;
		this.idCliente = this.ip+":"+String.valueOf(++nextClient);
		connectServer(serverIp,serverPort); 	 			 
	}
	
	public Client getClient() {
		return this.clientModel;
	}

	private void connectServer(String serverIp,int serverPort) {
		try{			
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
			 this.clientModel = new ClientModel(this.idCliente);
			 this.clientModel.addObserver(this.observador);
			 RemoteClient remoteClientModel = (RemoteClient) UnicastRemoteObject.exportObject(this.clientModel, port);
	         registro.bind("ClientePOO", remoteClientModel);
	        
	         System.out.println("Usted esta hosteando con la IP :" + this.ip + "-- Puerto: "+ this.port);	     
	         
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}
	}
	
}
