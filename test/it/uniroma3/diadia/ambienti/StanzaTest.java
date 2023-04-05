package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza vuota;
	private Stanza nonVuota;
	private Attrezzo osso;
	
	@BeforeEach
	public void setUp(){	
	this.vuota=new Stanza("vuota");
	this.nonVuota=new Stanza("non vuota");
	this.osso = new Attrezzo("osso", 1);
	
	this.nonVuota.addAttrezzo(this.osso);
	System.out.println("sto eseguendo il setup");
	
		
	}
	@Test
	void testAddAttrezzo() {
		assertFalse(this.vuota.hasAttrezzo("libro"));
		this.vuota.addAttrezzo(new Attrezzo("osso", 1));
		assertTrue(this.vuota.hasAttrezzo("osso"));
	}

	@Test
	void testHasAttrezzo() {
		assertFalse(this.vuota.hasAttrezzo("libro"));
		assertTrue(this.nonVuota.hasAttrezzo("osso"));
	}

	@Test
	void testGetAttrezzo() {
		assertSame(this.osso, this.nonVuota.getAttrezzo("osso"));
	}

	@Test
	void testRemoveAttrezzo() {	
		assertTrue(this.nonVuota.removeAttrezzo(this.osso));
		assertFalse(this.vuota.removeAttrezzo(this.osso));
	}

}
