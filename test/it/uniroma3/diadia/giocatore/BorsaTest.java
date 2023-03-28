package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	private Borsa borsavuota;
	private Attrezzo osso;
	private Attrezzo spada;
	private Borsa borsa;

	@BeforeEach
	public void setUp() {
	this.borsavuota=new Borsa(); 
	this.osso=new Attrezzo("osso" , 1);
	this.spada=new Attrezzo("spada", 10);
	this.borsa=new Borsa(); 
	this.borsa.addAttrezzo(osso);
	
	}
	

	@Test
	void testAddAttrezzo() {		
		assertTrue(this.borsa.hasAttrezzo("osso"));
	}

	@Test
	void testHasAttrezzo() {
		assertFalse(this.borsavuota.hasAttrezzo("spada"));
		
	}

	@Test
	void testRemoveAttrezzo() {
		this.borsa.removeAttrezzo("osso");
		assertFalse(this.borsa.hasAttrezzo("osso"));
		
	}

}
