package ar.edu.unlu.juego;

import java.util.Observable;
import java.util.Observer;

import ar.edu.unlu.server.ServerModel;
import ar.edu.unlu.server.Servidor;

public abstract class Juego implements Observer{
	
	private ServerModel serverModel;
	
	public Juego() {
		Servidor s = new Servidor();
		s.run();
		this.serverModel = s.getServerModel();
		this.serverModel.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		Thread actualizacionT=new Thread(){
	        @Override
	        public void run() {
	        	Juego.this.actualizacion(arg);	        	
	        };
	    };
	    
	    actualizacionT.start();		
	}
	
	protected abstract void actualizacion(Object arg);


}
