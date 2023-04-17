package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String chiave;
	
	public StanzaBloccata(String nome,String direzione, String attrezzo) {
		super(nome);
		this.direzioneBloccata=direzione;
		this.chiave=attrezzo;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!this.hasAttrezzo(this.chiave) && this.direzioneBloccata.equals(direzione)) {
			 return this;
		}
		else
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.chiave)) {			
			return "Stanza bloccata!\nDirezione bloccata: "+this.direzioneBloccata+". Per sbloccare questa direzione è necessario che l'attrezzo "+this.chiave+" sia presente nella stanza!\n\n"+super.getDescrizione();
		}
		else {
			return super.getDescrizione();
		}
		
	}
}
	
	
	
	

