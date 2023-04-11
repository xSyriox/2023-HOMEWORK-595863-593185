package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando { 
	private IOConsole ioconsole;
	
	@Override
	public void setParametro(String parametro) {
		return;
	}
	
	@Override
	public void esegui(Partita partita) {
		ioconsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
}
