package ar.edu.unlu.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observer;



public class ServerFactory{
   
    private ServerModel serverModel;

    public ServerFactory(Observer serverApp){
    	this(serverApp,RemoteServer.defaultServerIp,RemoteServer.defaultServerPort);
	}
    
	public ServerFactory(Observer serverApp, String ip,int port){
		try{
			 System.setProperty("java.rmi.server.hostname", ip);
			 Registry registro = LocateRegistry.createRegistry(port);
			 this.serverModel = new ServerModel();
			 RemoteServer remoteServerModel = (RemoteServer) UnicastRemoteObject.exportObject(this.serverModel, port);
	         registro.bind("ServerPOO", remoteServerModel);
	         
	         System.out.println("Usted esta hosteando con la IP :" + ip + "-- Puerto: "+ port);	     
	         this.serverModel.addObserver(serverApp);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}
	}
	
	public Server getServer() {
		return this.serverModel;
	}
	
}