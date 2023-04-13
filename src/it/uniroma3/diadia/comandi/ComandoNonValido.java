package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	private Comando comando;
	
	@Override
	public void setParametro(String parametro) {
		return;
	}
	
	public void esegui(Partita partita) {
		IO io = partita.getIo();
		this.comando=null;
		io.mostraMessaggio("Comando non disponibile. Scrivere aiuto per vedere la lista dei comandi disponibili.");
		return;
	}
	
	
	

}
