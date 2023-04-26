package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {
	private IOSimulator io;
	
	@BeforeEach
	void setUp() throws Exception{
		
	}
	
	@Test
	void testUnComando() {
		assertEquals("fine", new IOSimulator("fine").leggiRiga());
	}
	@Test
	void testDueComandi() {
		this.io=new IOSimulator("fine","vai nord");
		assertEquals("fine", this.io.leggiRiga());
		assertEquals("vai nord", this.io.leggiRiga());
	}
	@Test
	void testNessunComando() {
		io=new IOSimulator();
		assertNull(io.leggiRiga());
	}
	@Test
	void testTroppeLetture() {
		this.io=new IOSimulator("fine");
		assertEquals("fine", this.io.leggiRiga());
		this.io.leggiRiga();
	}

}
