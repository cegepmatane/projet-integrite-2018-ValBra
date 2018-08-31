package modele;

public class Equipe {

	protected String nom,pays,anneeDeCreation,stade,entraineur;
	
	public Equipe(String nom, String pays, String stade, String entraineur, String anneeDeCreation) {
		super();
		this.nom = nom;
		this.pays = pays;
		this.stade = stade;
		this.entraineur = entraineur;
		this.anneeDeCreation = anneeDeCreation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getStade() {
		return stade;
	}

	public void setStade(String stade) {
		this.stade = stade;
	}

	public String getEntraineur() {
		return entraineur;
	}

	public void setEntraineur(String entraineur) {
		this.entraineur = entraineur;
	}

	public String getAnneeDeCreation() {
		return anneeDeCreation;
	}

	public void setAnneeDeCreation(String anneeDeCreation) {
		this.anneeDeCreation = anneeDeCreation;
	}
	
}
