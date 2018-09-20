package action;

import java.util.ArrayList;
import java.util.List;

import accesseur.EquipeDAO;
import modele.Equipe;
import modele.Joueur;
import vue.NavigateurDesVues;
import vue.VueAjouterEquipe;
import vue.VueEditerEquipe;
import vue.VueEquipe;
import vue.VueListeEquipe;

public class ControleurEquipe {
	private NavigateurDesVues navigateur;
	private VueAjouterEquipe vueAjouterEquipe;
	private VueEquipe vueEquipe;
	private VueListeEquipe vueListeEquipe;
	private VueEditerEquipe vueEditerEquipe;
	private EquipeDAO equipeDAO;
	
	public ControleurEquipe() {
		this.equipeDAO = new EquipeDAO();
	}
	
	public void afficherVues(NavigateurDesVues navigateur) {
		this.navigateur = navigateur;
		this.vueAjouterEquipe = navigateur.getVueAjouterEquipe();
		this.vueEquipe = navigateur.getVueEquipe();
		this.vueEditerEquipe = navigateur.getVueEditerEquipe();
		this.vueListeEquipe = navigateur.getVueListeEquipe();
		
		//Test DAO
		//testListeEquipes.montrerListeEquipe();
		List<Equipe> listeEquipes = equipeDAO.montrerListeEquipe();
		vueListeEquipe.afficherListeEquipes(listeEquipes);
		//testListeEquipes.accesBaseDeDonnees();
				
		//Test vueEquipe
		List<Joueur> listeJoueursNancy = new ArrayList<Joueur>();
		listeJoueursNancy.add(new Joueur("Chernik","31","gardien"));
		Equipe equipe1 = new Equipe("AS Nancy","France","1967","Marcel Picot","Didier Tholot",listeJoueursNancy);
		vueEquipe.afficherEquipe(equipe1);
	}
	
	private static ControleurEquipe instance = null;
	public static ControleurEquipe getInstance() {
		if(null == instance) {
			instance = new ControleurEquipe();
		}
		return instance;
	}
	
	public void enregistrerEquipe() {
		Equipe equipe = this.navigateur.getVueAjouterEquipe().creerEquipe();
		this.equipeDAO.ajouterEquipe(equipe);
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
		this.navigateur.naviguerVersVueEditerEquipe();
		
	}
	
	public void notifierEnregistrerMouton() {
		Equipe equipe = this.navigateur.getVueEditerEquipe().demanderEquipe();
		this.equipeDAO.modifierEquipe(equipe);
		this.vueListeEquipe.afficherListeEquipes(this.equipeDAO.montrerListeEquipe());
		this.navigateur.naviguerVersVueListeEquipe();
	}
}
