package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	
	
	@Override
	public void esegui(Partita partita) {
		IO io = partita.getIo();
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
	}
	@Override
	public void setParametro(String paramentro) {
		return;
	}

}
