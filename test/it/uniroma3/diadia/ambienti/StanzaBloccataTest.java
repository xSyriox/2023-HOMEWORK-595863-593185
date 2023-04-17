package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	private StanzaBloccata stanza;
	private Attrezzo osso;
	private Stanza adiacente;
	private Stanza sud;
	private Attrezzo lancia;

	@BeforeEach
	public void setUp() {
		this.osso=new Attrezzo("osso", 10);
		this.lancia=new Attrezzo("lancia", 20);
		this.stanza=new StanzaBloccata("atrio", "nord", "osso");
		//this.stanza.addAttrezzo(lancia);
		this.adiacente=new Stanza("N10");
		this.stanza.impostaStanzaAdiacente("nord", this.adiacente);
		this.sud=new Stanza("N9");
		this.stanza.impostaStanzaAdiacente("sud", this.sud);
		
		
		
	}

	@Test
	void testGetStanzaAdiacente() {
		System.out.println(this.stanza.getDescrizione());
		assertSame(this.stanza, this.stanza.getStanzaAdiacente("nord"));
		this.stanza.addAttrezzo(osso);
		assertSame(this.adiacente, this.stanza.getStanzaAdiacente("nord"));
		assertSame(this.sud, this.stanza.getStanzaAdiacente("sud"));	
		
		
	}

}
