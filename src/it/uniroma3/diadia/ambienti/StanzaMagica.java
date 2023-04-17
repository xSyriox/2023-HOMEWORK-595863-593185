package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	 private int contatoreAttrezziPosati;
	 private int sogliaMagica;
	 
	 
	 /**
	  * Costruttore
	  *
	  */
	 public StanzaMagica(String nome, int soglia) {
		 super(nome);
		 this.contatoreAttrezziPosati = 0;
		 this.sogliaMagica = soglia;
	 }
	 
	 public StanzaMagica(String nome) {
	 this(nome, SOGLIA_MAGICA_DEFAULT);
	 }
	 ////////////////////////////////////
	 
	 /**
	  * modifica attrezzo se la stanza diventa magica
	 * @param attrezzo
	 * @return attrezzo modificato(nome invertito, peso raddoppiato)
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		 StringBuilder nomeInvertito;
		 int pesoX2 = attrezzo.getPeso() * 2;
		 nomeInvertito = new StringBuilder(attrezzo.getNome());
		 nomeInvertito = nomeInvertito.reverse();
		 attrezzo = new Attrezzo(nomeInvertito.toString(),
		 pesoX2);
		 return attrezzo;
	}
	
	 @Override
	 public boolean addAttrezzo(Attrezzo attrezzo) {
		 if(this.getNumeroAttrezzi()<getNumeroMassimoAttrezzi()) {
		 this.contatoreAttrezziPosati++;
		 if(this.contatoreAttrezziPosati>=this.sogliaMagica) {
			 attrezzo=this.modificaAttrezzo(attrezzo);
		 }
		 return super.addAttrezzo(attrezzo);}
		 else return false;
	 }
	 
	 


}
