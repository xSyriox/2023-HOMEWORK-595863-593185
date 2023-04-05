package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	private IOConsole ioconsole;
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
	
	@Override
	public void setParametro(String parametro) {
		return;
	}
	@Override
	public void esegui(Partita partita) {
        for(int i=0; i< elencoComandi.length; i++)
            ioconsole.mostraMessaggio(elencoComandi[i]+" ");
        ioconsole.mostraMessaggio("------");
		
	}
	

}
