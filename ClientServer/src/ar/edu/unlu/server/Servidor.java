package ar.edu.unlu.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



public class Servidor implements Runnable {
   
    private int port;
    private String iPhost;
	

    public Servidor(){
    	this("127.0.0.1",7896);
	}
    
	public Servidor(String ip,int port){
		iPhost=ip;
		this.port=port;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			 System.setProperty("java.rmi.server.hostname", iPhost);
			 Registry registro = LocateRegistry.createRegistry(port);
			 IServerModel remoteServerModel = (IServerModel) UnicastRemoteObject.exportObject(new ServerModel(), port);
	         registro.bind("ServerPOO", remoteServerModel);
	        
	         System.out.println("Usted esta hosteando con la IP :" + iPhost + "-- Puerto: "+ port);	     
	         
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}

	}
	
	public static void main(String[] args) {
		Servidor me = new Servidor();
		me.run();		
	}
	
	
}