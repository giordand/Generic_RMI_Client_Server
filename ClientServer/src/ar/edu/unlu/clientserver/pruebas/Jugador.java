package ar.edu.unlu.clientserver.pruebas;

import ar.edu.unlu.clientserver.appcliente.ClientApp;

public class Jugador extends ClientApp{

	public Jugador() {
		super("127.0.0.1",8734,"127.0.0.1",12001);
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
