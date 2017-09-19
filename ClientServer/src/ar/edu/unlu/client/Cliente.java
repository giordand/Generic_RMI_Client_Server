package ar.edu.unlu.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import ar.edu.unlu.server.IServerModel;



public class Cliente{
	
	private IServerModel server;
	private String ip;
	private int port;
	private ClientModel clientModel;

	
	public Cliente(){
		this("127.0.0.1",9876);
	}
	public Cliente(String ip, int port){
		this.ip = ip;
		this.port = port;
		connectServer(); 	 			 
	}
	
	public ClientModel getClientModel() {
		return this.clientModel;
	}

	private void connectServer() {
		try{ 								
			//Deberia poder parametrizarse
			String serverIp = "127.0.0.1";
			int serverPort = 7896;
			
			//Me conecto al servidor
			Registry registro=LocateRegistry.getRegistry(serverIp, serverPort);
			this.server=(IServerModel)registro.lookup("ServerPOO");
			System.out.println("Conectado al server");
			//Creo el server del cliente
			createServer();
			//Thread.sleep(4000);
			/*
			 * Le pido al servidor (juego) que me agregue como cliente. Le paso mi IP y PORT para que
			 * se conecte a mi server
			 */			
			this.server.register(this.ip ,this.port);
			
		}catch(Exception ex){
			System.out.println(ex);
		}
		
	}
	private void createServer() {	
		try{
			 System.setProperty("java.rmi.server.hostname", this.ip);
			 Registry registro = LocateRegistry.createRegistry(this.port);
			 this.clientModel = new ClientModel("Cliente1");
			 IClientModel remoteClientModel = (IClientModel) UnicastRemoteObject.exportObject(this.clientModel, port);
	         registro.bind("ClientePOO", remoteClientModel);
	        
	         System.out.println("Usted esta hosteando con la IP :" + this.ip + "-- Puerto: "+ this.port);	     
	         
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}
	}
	
}
