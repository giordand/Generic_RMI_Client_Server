package ar.edu.unlu.pruebas;

import ar.edu.unlu.appcliente.ClientApp;

public class Jugador extends ClientApp{

	public Jugador() {
		super("192.168.157.101",8734,"192.168.157.101",9999);
	}

	@Override
	protected void actualizacion(Object arg) {
		// TODO Auto-generated method stub
		System.out.println("El jugador recibio el mensaje : \""+arg+"\"");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin update JUGADOR");
	}
	
	@Override
	public void sendMessageToServer(Object o) {
		super.sendMessageToServer(o);
	}
}
