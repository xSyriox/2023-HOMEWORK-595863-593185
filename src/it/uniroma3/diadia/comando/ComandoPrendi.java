package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando {
	
	private String nomeAttrezzo;
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		
		 Borsa borsa =partita.getGiocatore().getBorsa();
         Stanza stanzaCorrente =partita.getStanzaCorrente();
         IO io = partita.getIo();
         
         
         if (stanzaCorrente.hasAttrezzo(nomeAttrezzo) && borsa.getPeso() < borsa.getPesoMax()) {
             Attrezzo item= stanzaCorrente.getAttrezzo(nomeAttrezzo);
             stanzaCorrente.removeAttrezzo(item);
             borsa.addAttrezzo(item);
             io.mostraMessaggio("attrezzo raccolto");
         }
     else if (borsa.getPeso() >= borsa.getPesoMax() && !stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
             io.mostraMessaggio("Borsa piena e Attrezzo non presente nella stanza");
     	}
     else if (borsa.getPeso() >= borsa.getPesoMax()) {
             io.mostraMessaggio("Borsa piena");
     	}
     else if (!stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
             io.mostraMessaggio("Attrezzo non presente nella stanza");
     	}
         
		
	}
	

}
