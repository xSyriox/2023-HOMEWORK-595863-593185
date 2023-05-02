package it.uniroma3.diadia.ambienti;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.*;


/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
    protected Set<Attrezzo> attrezzi;
    protected int numeroAttrezzi;
    private List<Stanza> stanzeAdiacenti;
    private int numeroStanzeAdiacenti;
	private List<String> direzioni;
    
    public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}

	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}

	public static int getNumeroMassimoAttrezzi() {
		return NUMERO_MASSIMO_ATTREZZI;
	}

	/**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni = new ArrayList<>(4);
        this.stanzeAdiacenti = new ArrayList<>();
        this.attrezzi = new HashSet<>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        boolean aggiornato = false;
        Iterator<String> iteratore= this.direzioni.iterator();
        while (iteratore.hasNext()) {
			String elem = (String) iteratore.next();
			if(elem.equals(direzione)) {
				this.stanzeAdiacenti.add(stanza);
				aggiornato= true;
			}
			
		}
    	
    	if (!aggiornato)
    		if (this.stanzeAdiacenti.size() < NUMERO_MASSIMO_DIREZIONI) {
    			this.direzioni.add(numeroStanzeAdiacenti, direzione); 
    			this.stanzeAdiacenti.add(numeroStanzeAdiacenti, stanza);
    		    this.numeroStanzeAdiacenti++;
    		}
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
        Iterator<Stanza> iteratore= this.stanzeAdiacenti.iterator();
        int contatore=0;
        while (iteratore.hasNext()) {
			Stanza elem = (Stanza) iteratore.next();			
			if(this.direzioni.get(contatore).equals(direzione)) {
				stanza=elem;
				return stanza;
			}
			contatore++;			
		}       
		
        return null;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Attrezzo[] getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi[numeroAttrezzi] = attrezzo;
        	this.numeroAttrezzi++;
        	return true;
        }
        else {
        	return false;
        }
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append("Sei in: ");
    	risultato.append(this.nome);
    	risultato.append("\nUscite disponibili: ");
    	for (String direzione : this.direzioni)
    		if (direzione!=null)
    			risultato.append(" " + direzione);
    	if(this.isVuota()) {
    		risultato.append("\nAttrezzi nella stanza: nessuno");
    	}
    	else {
    	risultato.append("\nAttrezzi nella stanza: ");    	
    	for (Attrezzo attrezzo : this.attrezzi) {
    		if(attrezzo!=null) {
    		risultato.append(attrezzo.toString()+" ");}
    	
    	}}    	
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo !=null && attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(this.hasAttrezzo(attrezzo.getNome())) {
			for(int i=0; i<numeroAttrezzi; i++) {
				if(attrezzi[i].equals(attrezzo)) {
					attrezzi[i]=attrezzi[numeroAttrezzi-1];
					attrezzi[numeroAttrezzi-1]=null;
					numeroAttrezzi--;
					return true;
				}
			}		
	}
		return false;
	}
//	public boolean removeAttrezzo(String attrezzo) {
//		if(this.hasAttrezzo(attrezzo)){
//			for(int i=0; i<numeroAttrezzi; i++) {
//				if(attrezzi[i].getNome().equals(attrezzo)) {
//					attrezzi[i]=attrezzi[numeroAttrezzi-1];
//					attrezzi[numeroAttrezzi-1]=null;
//					numeroAttrezzi--;
//					return true;
//				}
//			}		
//		}
//		return false;
//	}
	


	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
	    	direzioni[i] = this.direzioni[i];
	    return direzioni;
    }
	
	public boolean isVuota() {
		if (this.numeroAttrezzi>0) return false;
		else return true;		
	}

}