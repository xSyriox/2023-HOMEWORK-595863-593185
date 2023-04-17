package it.uniroma3.diadia.ambienti;


public class StanzaBuia extends Stanza {
	private String nomeOggetto;
	
	
	public StanzaBuia(String nome, String nomeOggetto) {
		super(nome);
		this.nomeOggetto = nomeOggetto;
	}

	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(nomeOggetto))
			return "qui c'è un buio pesto";
		else
			return super.getDescrizione();
	}
	
	
}
	
