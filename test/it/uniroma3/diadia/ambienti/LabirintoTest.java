package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {
	
	private Labirinto labirinto;
	private Stanza atrio;
	private Stanza biblioteca;

	@BeforeEach
	public void setUp() {
		this.labirinto=new Labirinto();
		this.atrio=new Stanza("atrio");
		this.biblioteca=new Stanza("biblioteca");
		this.labirinto.setEntrata(atrio);
		this.labirinto.setUscita(biblioteca);
	}

	@Test
	void testGetEntrata() {
		assertEquals(this.atrio, this.labirinto.getEntrata());
	}

	@Test
	void testSetEntrata() {
		this.labirinto.setEntrata(atrio);
		assertEquals(this.atrio, this.labirinto.getEntrata());
	
	}

	@Test
	void testGetUscita() {
		assertEquals(this.biblioteca , this.labirinto.getUscita());
	}

	@Test
	void testSetUscita() {
		this.labirinto.setUscita(biblioteca);
		assertEquals(this.biblioteca , this.labirinto.getUscita());
	}

}
