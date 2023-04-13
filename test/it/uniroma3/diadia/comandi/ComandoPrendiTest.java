package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {
	
	private Partita partita;
	private IOConsole io;
	private Attrezzo lancia;
	private Comando comandodaEseguire;
	private FabbricaDiComandi fabbrica;
	private Attrezzo osso;
	
	
	@BeforeEach
	public void setUp() {
		this.io=new IOConsole();
		this.partita=new Partita(io);	
		this.fabbrica= new FabbricaDiComandiFisarmonica();
		this.comandodaEseguire=this.fabbrica.costruisciComando("prendi");
		Stanza stanzaCorrente=this.partita.getStanzaCorrente();
		this.osso=stanzaCorrente.getAttrezzo("osso");
		
	}
	
	
	@Test
	void testEsegui() {
		Stanza stanzaCorrente=this.partita.getStanzaCorrente();
		this.comandodaEseguire.setParametro("osso");
		this.comandodaEseguire.esegui(partita);		
		assertEquals(this.partita.getGiocatore().getBorsa().getAttrezzo("osso"), this.osso);
		assertFalse(stanzaCorrente.hasAttrezzo("osso"));		
		


	}

}
