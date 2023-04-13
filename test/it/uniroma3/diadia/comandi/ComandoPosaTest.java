package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	
	private Partita partita;
	private IOConsole io;
	private Attrezzo lancia;
	private Comando comandodaEseguire;
	private FabbricaDiComandi fabbrica;

	@BeforeEach
	public void setUp() {		
		this.io=new IOConsole();
		this.partita=new Partita(io);		
		this.lancia=new Attrezzo("lancia", 10);
		this.fabbrica= new FabbricaDiComandiFisarmonica();
		this.comandodaEseguire=this.fabbrica.costruisciComando("posa");
		
	}	

	@Test
	void testEsegui() {
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
		stanzaCorrente.removeAttrezzo(stanzaCorrente.getAttrezzo("osso"));
		this.partita.getGiocatore().getBorsa().addAttrezzo(lancia);
		this.comandodaEseguire.setParametro("lancia");
		this.comandodaEseguire.esegui(this.partita);	
		
		assertEquals(this.lancia, this.partita.getStanzaCorrente().getAttrezzi()[0]);		
	}
	@Test
	void testEsegui2() {
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();		
		
		this.comandodaEseguire.setParametro("lancia");
		this.comandodaEseguire.esegui(this.partita);
		
		assertFalse(stanzaCorrente.getAttrezzi()[0].equals(this.lancia));
				
	}

}
