package model;

public class Personne {

	private Long id;
	private String nom;
	private String prenom;
	private String motPasse;
	
	
	
	public Personne() {	}
	public Personne( String nom, String prenom, String motPasse) {
		super();

		this.nom = nom;
		this.prenom = prenom;
		this.motPasse = motPasse;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", motPasse=" + motPasse + "]";
	}
	
	
}
