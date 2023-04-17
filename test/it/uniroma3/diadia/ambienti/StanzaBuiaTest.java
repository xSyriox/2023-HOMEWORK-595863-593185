package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {	
	private StanzaBuia stanza;
	private Attrezzo osso;
	private Attrezzo lancia;
	private Stanza uguale;

	@BeforeEach
	public void setUp() {
		this.osso=new Attrezzo("osso", 10);
		this.lancia=new Attrezzo("lancia", 20);
		this.stanza=new StanzaBuia("atrio", "osso");
		this.uguale=new Stanza("atrio");
		this.uguale.addAttrezzo(lancia);
		this.uguale.addAttrezzo(osso);
		
		this.stanza.addAttrezzo(lancia);
	}

	@Test
	void testGetDescrizione() {
		assertEquals("qui c'è un buio pesto", this.stanza.getDescrizione());
		this.stanza.addAttrezzo(this.osso);
		assertEquals(this.uguale.getDescrizione(), this.stanza.getDescrizione());		
	}

}
