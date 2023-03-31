package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {	
	private Labirinto labirinto;	
	private Partita partita;

	
	private Stanza stanzavincente;
	

	@BeforeEach
	public void setUp() {
		this.partita=new Partita();
		this.stanzavincente=new Stanza("biblioteca");
		this.partita.getLabirinto().setUscita(stanzavincente);
		this.partita.setStanzaCorrente(stanzavincente);		
		
		
		
	}

	@Test
	void testgetStanzaVincente() {
		assertSame(this.stanzavincente, this.partita.getStanzaVincente());
	}

	

	@Test
	void testVinta() {
		assertTrue(partita.vinta());
	}

}
