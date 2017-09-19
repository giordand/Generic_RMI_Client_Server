package ar.edu.unlu.pruebas;

import java.util.Observable;
import java.util.Observer;

import ar.edu.unlu.client.ClientModel;
import ar.edu.unlu.client.Cliente;

public class Jugador implements Observer{
	private ClientModel clientModel;
	
	public Jugador() {
		Cliente c = new Cliente();
		this.clientModel = c.getClientModel();
		this.clientModel.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
