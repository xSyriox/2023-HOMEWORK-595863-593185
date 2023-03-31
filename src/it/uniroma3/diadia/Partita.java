package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;


/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	

	private Stanza stanzaCorrente;
	private Labirinto labirinto;
	private boolean finita;
	
	private Giocatore giocatore;
	
	public Partita(){
		this.labirinto=new Labirinto();
		this.stanzaCorrente=labirinto.getEntrata();
		this.finita = false;
		
		this.giocatore=new Giocatore();
		
	}
	
	public Labirinto getLabirinto() {
		return labirinto;
	}


	public Giocatore getGiocatore() {
		return giocatore;
	}




	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}




	public Stanza getStanzaVincente() {
		return this.labirinto.getUscita();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()==this.labirinto.getUscita();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

		
}
