package ar.edu.unlu.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import ar.edu.unlu.appserver.ServerApp;



public class ServerFactory{
   
    private String iPhost;
    private ServerModel serverModel;
	

    public ServerFactory(ServerApp serverApp){
    	this(serverApp,"127.0.0.1",7896);
	}
    
	public ServerFactory(ServerApp serverApp, String ip,int port){
		iPhost=ip;
		try{
			 System.setProperty("java.rmi.server.hostname", iPhost);
			 Registry registro = LocateRegistry.createRegistry(port);
			 this.serverModel = new ServerModel();
			 RemoteServer remoteServerModel = (RemoteServer) UnicastRemoteObject.exportObject(this.serverModel, port);
	         registro.bind("ServerPOO", remoteServerModel);
	         
	         System.out.println("Usted esta hosteando con la IP :" + iPhost + "-- Puerto: "+ port);	     
	         this.serverModel.addObserver(serverApp);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}
	}
	
	public Server getServerModel() {
		return this.serverModel;
	}
	
}