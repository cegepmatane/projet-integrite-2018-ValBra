package action;

import java.util.ArrayList;
import java.util.List;

import modele.Equipe;
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
		
		//Test vueListeEquipe
		List<Equipe> listeEquipesTest = new ArrayList<Equipe>();
		listeEquipesTest.add(new Equipe("AS Nancy", "France", "1967", "Marcel Picot","Didier Tholot"));
		listeEquipesTest.add(new Equipe("Impact Montréal", "Canada", "1992", "Saputo","Rémi Garde"));
		listeEquipesTest.add(new Equipe("Celtic Glasgow", "Ecosse", "1892", "Celtic Park","Brendan Rogers"));
		vueListeEquipe.afficherListeEquipes(listeEquipesTest);
				
		//Test vueEquipe
		Equipe equipe1 = new Equipe("AS Nancy","France","1967","Marcel Picot","Didier Tholot");
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
