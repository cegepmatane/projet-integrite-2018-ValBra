package action;

import java.util.ArrayList;
import java.util.List;

import donnees.EquipeDAO;
import donnees.JoueurDAO;
import modele.Equipe;
import modele.Joueur;
import vue.NavigateurDesVues;
import vue.VueAjouterEquipe;
import vue.VueAjouterJoueur;
import vue.VueEditerEquipe;
import vue.VueEditerJoueur;
import vue.VueEquipe;
import vue.VueListeEquipe;

public class ControleurEquipe {
	private NavigateurDesVues navigateur;
	private VueAjouterEquipe vueAjouterEquipe;
	private VueEquipe vueEquipe;
	private VueListeEquipe vueListeEquipe;
	private VueEditerEquipe vueEditerEquipe;
	private VueAjouterJoueur vueAjouterJoueur;
	private VueEditerJoueur vueEditerJoueur;
	private EquipeDAO equipeDAO;
	private JoueurDAO joueurDAO;
	
	public ControleurEquipe() {
		this.equipeDAO = new EquipeDAO();
		this.joueurDAO = new JoueurDAO();
	}
	
	public void afficherVues(NavigateurDesVues navigateur) {
		this.navigateur = navigateur;
		this.vueAjouterEquipe = navigateur.getVueAjouterEquipe();
		this.vueEquipe = navigateur.getVueEquipe();
		this.vueEditerEquipe = navigateur.getVueEditerEquipe();
		this.vueListeEquipe = navigateur.getVueListeEquipe();
		this.vueAjouterJoueur = navigateur.getVueAjouterJoueur();
		this.vueEditerJoueur = navigateur.getVueEditerJoueur();
		
		Equipe equipe1 = new Equipe("AS Nancy","France","1967","Marcel Picot","Didier Tholot");
		this.vueEquipe.afficherEquipe(equipe1);
		this.navigateur.naviguerVersVueEquipe();
		
		//Test DAO
		List<Equipe> listeEquipes = equipeDAO.montrerListeEquipe();
		vueListeEquipe.afficherListeEquipes(listeEquipes);
		this.navigateur.naviguerVersVueListeEquipe();
		
	}
	
	private static ControleurEquipe instance = null;
	public static ControleurEquipe getInstance() {
		if(null == instance) {
			instance = new ControleurEquipe();
		}
		return instance;
	}
	
	public void enregistrerNouvelleEquipe() {
		Equipe equipe = this.navigateur.getVueAjouterEquipe().creerEquipe();
		this.equipeDAO.ajouterEquipe(equipe);
		this.vueListeEquipe.afficherListeEquipes(this.equipeDAO.montrerListeEquipe());
		this.navigateur.naviguerVersVueListeEquipe();
	}
	
	public void enregistrerEquipe() {
		Equipe equipe = this.navigateur.getVueEditerEquipe().demanderEquipe();
		this.equipeDAO.modifierEquipe(equipe);
		this.vueListeEquipe.afficherListeEquipes(this.equipeDAO.montrerListeEquipe());
		this.navigateur.naviguerVersVueListeEquipe();
	}
	
	public void notifierNaviguerAjouterEquipe()
	{
		this.navigateur.naviguerVersVueAjouterEquipe();
	}
	
	public void notifierNaviguerEditerEquipe(int idEquipe)
	{
		this.vueEditerEquipe.afficherEquipe(this.equipeDAO.rapporterEquipe(idEquipe));
		this.vueEditerEquipe.afficherEffectif(this.joueurDAO.listerJoueurs(idEquipe));
		this.navigateur.naviguerVersVueEditerEquipe();
		
	}
	
	public void enregistrerNouveauJoueur() {
		Joueur joueur = this.navigateur.getVueAjouterJoueur().creerJoueur();
		this.joueurDAO.ajouterJoueur(joueur);
		this.navigateur.naviguerVersVueListeEquipe();
	}
	
	public void notifierNaviguerAjouterJoueur()
	{
		this.navigateur.naviguerVersVueAjouterJoueur();
	}
}
