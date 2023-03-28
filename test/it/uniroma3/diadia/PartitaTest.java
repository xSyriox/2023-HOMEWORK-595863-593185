package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	private Stanza atrio;
	private Stanza stanzaCorrente;
	private Labirinto labirinto;	
	private int cfu;

	@BeforeEach
	public void setUp() {		
		this.atrio=new Stanza("atrio");
		this.stanzaCorrente=new Stanza("stanza corrente");
		this.labirinto=new Labirinto();
		this.labirinto.setUscita(atrio);
		this.cfu=10;
	}

	@Test
	void testGetStanzaVincente() {
		assertSame(this.atrio,this.labirinto.getUscita());
	}

	@Test
	void testgetCfu() {
		assertSame(this.cfu, 10);		
		
	}

	@Test
	void testVinta() {
		this.stanzaCorrente=atrio;
		assertSame(this.stanzaCorrente, this.labirinto.getUscita());
		
	}

}
