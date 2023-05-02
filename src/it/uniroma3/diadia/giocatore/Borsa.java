package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.uniroma3.diadia.attrezzi.*;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;	
	private int pesoMax;
	
	
	public Borsa() {
	this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
	this.pesoMax = pesoMax;
	this.attrezzi = new ArrayList<>();
	
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
	if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
		return false;	
	return this.attrezzi.add(attrezzo);	
	}
	
	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}

	

	public int getPesoMax() {
	return pesoMax;}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore= this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			a=iteratore.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				return a;}
				
			
		}	
		
		return null;}
		
	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iteratore= this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			Attrezzo elem = (Attrezzo) iteratore.next();
			peso+=elem.getPeso();			
		}
		
		return peso;}
		
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;}
	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		 if (!this.isEmpty()) {
			 s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			 Iterator<Attrezzo> iteratore= this.attrezzi.iterator();
			 while (iteratore.hasNext()) {
				 Attrezzo elem = (Attrezzo) iteratore.next();
				 s.append(elem.toString()+ " ");
		}
		 
		 }
		 else
			 s.append("Borsa vuota");
		 return s.toString();}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;		
		Iterator<Attrezzo> iteratore= this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			a=iteratore.next();
			if(a.getNome().equals(nomeAttrezzo))
				iteratore.remove();
				return a; }						
			
		return null;
		}
	
	
	
	
	

		

	


}
