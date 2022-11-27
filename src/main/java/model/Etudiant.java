package model;

import model.Personne;
public class Etudiant extends Personne {

	private String CNE;

	public Etudiant() {}
	public Etudiant(String cNE) {
		super();
		this.CNE=cNE;
	}
	public Etudiant(String cne,String nom,String prenom,String motPasse) {
		super(nom,prenom,motPasse);
		this.CNE = cne;
	}
	
	public String getCNE() {
		return CNE;
	}

	public void setCNE(String string) {
		CNE = string;
	}
	@Override
	public String toString() {
		return "Etudiant [CNE=" + CNE + "]";
	}

	
	
}
