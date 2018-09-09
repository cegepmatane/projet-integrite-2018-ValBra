package modele;

public class Joueur {
	protected String nom, age, poste;
	protected Equipe equipe;
	public Joueur(String nom, String age, String poste) {
		super();
		this.nom = nom;
		this.age = age;
		this.poste = poste;
	}
	public Joueur(String nom, String age, String poste, Equipe equipe) {
		super();
		this.nom = nom;
		this.age = age;
		this.poste = poste;
		this.equipe = equipe;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
}
