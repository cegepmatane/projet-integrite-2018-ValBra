package action;

import java.util.ArrayList;
import java.util.List;

import accesseur.EquipeDAO;
import modele.Equipe;
import modele.Joueur;
import vue.NavigateurDesVues;
import vue.VueAjouterEquipe;
import vue.VueEquipe;
import vue.VueListeEquipe;

public class ControleurEquipe {
	private NavigateurDesVues navigateur;
	private VueAjouterEquipe vueAjouterEquipe;
	private VueEquipe vueEquipe;
	private VueListeEquipe vueListeEquipe;
	
	public ControleurEquipe() {
		
	}
	
	public void afficherVues(NavigateurDesVues navigateur) {
		this.navigateur = navigateur;
		this.vueAjouterEquipe = navigateur.getVueAjouterEquipe();
		this.vueEquipe = navigateur.getVueEquipe();
		this.vueListeEquipe = navigateur.getVueListeEquipe();
		
		//Test DAO
		EquipeDAO testListeEquipes = new EquipeDAO();
		List<Equipe> listeEquipes = testListeEquipes.montrerListeEquipe();
		vueListeEquipe.afficherListeEquipes(listeEquipes);
				
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
}
