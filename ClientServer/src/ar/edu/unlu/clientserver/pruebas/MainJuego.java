package ar.edu.unlu.clientserver.pruebas;



public class MainJuego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Juego j = new Juego();
		System.out.println("Juego creado");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j.sendMessageToClients("El juego envio un mensaje!!!");
	}

}
