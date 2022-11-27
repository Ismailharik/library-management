package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Livre {

	private long num;
	private String titre;
	private Set<Exemplaire> exemplaires = new HashSet<Exemplaire>();
	
	public Livre() {}
	public Livre(long num, String titre) {
		super();
		this.num = num;
		this.titre = titre;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Set<Exemplaire> getExemplaires() {
		return exemplaires;
	}
	public void setExemplaires(Set<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}
	
	
}
