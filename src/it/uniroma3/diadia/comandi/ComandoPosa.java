package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando{
	
	private String nomeAttrezzo;
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		Borsa borsa = partita.getGiocatore().getBorsa();
        Stanza stanzaCorrente =partita.getStanzaCorrente();
        IO io = partita.getIo();

        if (borsa.hasAttrezzo(nomeAttrezzo) && stanzaCorrente.getNumeroAttrezzi()< Stanza.getNumeroMassimoAttrezzi()) {
                Attrezzo item= borsa.removeAttrezzo(nomeAttrezzo);
                stanzaCorrente.addAttrezzo(item);
                io.mostraMessaggio("attrezzo posato");
        }
        else if (!borsa.hasAttrezzo(nomeAttrezzo) && stanzaCorrente.getNumeroAttrezzi()>= Stanza.getNumeroMassimoAttrezzi())
                io.mostraMessaggio("Attrezzo non presente in borsa e stanza piena");

        else if (!borsa.hasAttrezzo(nomeAttrezzo))
                io.mostraMessaggio("Attrezzo non presente in borsa");

        else if (stanzaCorrente.getNumeroAttrezzi() >= Stanza.getNumeroMassimoAttrezzi())
                io.mostraMessaggio("stanza piena");
	}
	

}
