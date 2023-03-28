package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {
	private Giocatore giocatore;
	private Borsa borsa;

	@BeforeEach
	public void setUp() {
		this.giocatore=new Giocatore();
		this.borsa=new Borsa();
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
		fail("Not yet implemented");
	}

	@Test
	void testSetCfu() {
		fail("Not yet implemented");
	}

}
