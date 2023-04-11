package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	private Comando comando;
	
	@Override
	public void setParametro(String parametro) {
		return;
	}
	
	public void esegui(Partita partita) {
		this.comando=null;
		return;
	}
	
	
	

}
