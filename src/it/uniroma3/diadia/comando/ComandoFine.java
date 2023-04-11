package it.uniroma3.diadia.comando;


import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	
	
	@Override
	public void esegui(Partita partita) {
		partita.getIoconsole().mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
	}
	@Override
	public void setParametro(String paramentro) {
		return;
	}

}
