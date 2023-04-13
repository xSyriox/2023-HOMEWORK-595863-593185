package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando { 
	
	
	@Override
	public void setParametro(String parametro) {
		return;
	}
	
	@Override
	public void esegui(Partita partita) {
		IO io = partita.getIo();
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
}
