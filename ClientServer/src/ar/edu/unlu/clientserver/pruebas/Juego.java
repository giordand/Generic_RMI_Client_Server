package ar.edu.unlu.clientserver.pruebas;

import ar.edu.unlu.clientserver.appserver.ServerApp;

public class Juego extends ServerApp{
	
	public Juego() {
		super("192.168.157.101",9999);
	}

	@Override
	protected void actualizacion(Object arg) {
		// TODO Auto-generated method stub
		System.out.println("El juego recibio el mensaje : \""+arg+"\"");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin update");
	}
	
	public void sendMessageToClients(Object o) {
		super.sendMessageToClients(o);
	}

}
