package model;

import java.util.ArrayList;
import java.util.List;

public class Exemplaire {

	private String code;
	private boolean disponible;
	private List<Personne>  personnes= new ArrayList<>();
	private Livre livre = new Livre();
	
	public Exemplaire() {}
	public Exemplaire(String code, boolean disponible, List<Personne> personnes, Livre livre) {
		super();
		this.code = code;
		this.disponible = disponible;
		this.personnes = personnes;
		this.livre = livre;
	}
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	
}
