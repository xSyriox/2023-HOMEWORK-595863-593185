package it.uniroma3.diadia.comando;


import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando { 
	
	
	@Override
	public void setParametro(String parametro) {
		return;
	}
	
	@Override
	public void esegui(Partita partita) {
		partita.getIoconsole().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
}
