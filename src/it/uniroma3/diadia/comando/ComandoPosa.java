package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando{
	private IOConsole ioconsole;
	private String nomeAttrezzo;
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		Borsa borsa = partita.getGiocatore().getBorsa();
        Stanza stanzaCorrente =partita.getStanzaCorrente();

        if (borsa.hasAttrezzo(nomeAttrezzo) && stanzaCorrente.getNumeroAttrezzi()< Stanza.getNumeroMassimoAttrezzi()) {
                Attrezzo item= borsa.removeAttrezzo(nomeAttrezzo);
                stanzaCorrente.addAttrezzo(item);
                ioconsole.mostraMessaggio("attrezzo posato");
        }
        else if (!borsa.hasAttrezzo(nomeAttrezzo) && stanzaCorrente.getNumeroAttrezzi()>= Stanza.getNumeroMassimoAttrezzi())
                ioconsole.mostraMessaggio("Attrezzo non presente in borsa e stanza piena");

        else if (!borsa.hasAttrezzo(nomeAttrezzo))
                ioconsole.mostraMessaggio("Attrezzo non presente in borsa");

        else if (stanzaCorrente.getNumeroAttrezzi() >= Stanza.getNumeroMassimoAttrezzi())
                ioconsole.mostraMessaggio("stanza piena");
	}
	

}
