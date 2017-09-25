package ar.edu.unlu.pruebas;

import ar.edu.unlu.appserver.ServerApp;

public class Juego extends ServerApp{

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
