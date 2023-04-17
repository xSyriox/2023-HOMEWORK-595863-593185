package it.uniroma3.diadia.comandi;

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
         
         
         if(!stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
        	 if (borsa.getPeso() >= borsa.getPesoMax()) {
        		io.mostraMessaggio("Borsa piena e Attrezzo non presente nella stanza");}
        	 else{
        		io.mostraMessaggio("Attrezzo non presente nella stanza");
        		 }        	 
         }
         
         
        else if (stanzaCorrente.hasAttrezzo(nomeAttrezzo) && borsa.getPeso()+stanzaCorrente.getAttrezzo(nomeAttrezzo).getPeso() <= borsa.getPesoMax()) {
             Attrezzo item= stanzaCorrente.getAttrezzo(nomeAttrezzo);
             stanzaCorrente.removeAttrezzo(item);
             borsa.addAttrezzo(item);
             io.mostraMessaggio("attrezzo raccolto");
         }
     		
     	else if (borsa.getPeso()>= borsa.getPesoMax()) {
             io.mostraMessaggio("Borsa piena");
     	}
     	else if (borsa.getPeso()+stanzaCorrente.getAttrezzo(nomeAttrezzo).getPeso() > borsa.getPesoMax()) {
         io.mostraMessaggio("Non hai abbastanza spazio nella borsa");
 	}
         
		
	}
	

}
