package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {
	static final private int CFU_INIZIALI = 20;
	private Giocatore giocatore;
	private Borsa borsa;
	private int cfu;

	@BeforeEach
	public void setUp() {
		this.giocatore=new Giocatore();
		this.borsa=new Borsa();
		this.giocatore.setCfu(10);
		
	}


	@Test
	void testGetBorsa() {
		this.giocatore.setBorsa(borsa);
		assertEquals(this.borsa, this.giocatore.getBorsa());
	}

	@Test
	void testSetBorsa() {
		this.giocatore.setBorsa(borsa);
		assertSame(this.borsa, this.giocatore.getBorsa());
	}

	@Test
	void testGetCfu() {
		
		assertTrue(this.giocatore.getCfu()==(10));
	}

	@Test
	void testSetCfu() {
		this.giocatore.setCfu(20);
		assertTrue(this.giocatore.getCfu()==20);
	}

}
