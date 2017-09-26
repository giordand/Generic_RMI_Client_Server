package ar.edu.unlu.pruebas;

public class MainJugador {

	public static void main(String[] args) {
		
		Jugador j = new Jugador();
		System.out.println("Jugador creado");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j.sendMessageToServer("Mensaje del clienteeeee");
		System.out.println("El jugador ya envio el mensaje");
		
	}

}
