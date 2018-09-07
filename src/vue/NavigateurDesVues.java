package vue;

import java.util.ArrayList;
import java.util.List;

import action.ControleurEquipe;
import javafx.application.Application;
import javafx.stage.Stage;
import modele.Equipe;

public class NavigateurDesVues extends Application{
	
	private VueAjouterEquipe vueAjouterEquipe = new VueAjouterEquipe();
	private VueEquipe vueEquipe = new VueEquipe();
	private VueListeEquipe vueListeEquipe = new VueListeEquipe();
	private Stage stade;
	private ControleurEquipe controleur;
	
	public NavigateurDesVues() {
		//Test vueListeEquipe
		List<Equipe> listeEquipesTest = new ArrayList<Equipe>();
		listeEquipesTest.add(new Equipe("Nancy", "France", "1967", "Marcel Picot","Didier Tholot"));
		listeEquipesTest.add(new Equipe("Impact Montréal", "Canada", "1992", "Saputo","Rémi Garde"));
		listeEquipesTest.add(new Equipe("Celtic Glasgow", "Ecosse", "1892", "Celtic Park","Brendan Rogers"));
		vueListeEquipe.afficherListeEquipes(listeEquipesTest);
		
		//Test vueEquipe
		Equipe equipe1 = new Equipe("AS Nancy","France","1967","Marcel Picot","Didier Tholot");
		vueEquipe.afficherEquipe(equipe1);
	}

	@Override
	public void start(Stage stade) throws Exception {
		this.stade=stade;
		stade.setScene(this.vueEquipe);
		stade.show();
	}
	
	public VueAjouterEquipe getVueAjouterEquipe() {
		return vueAjouterEquipe;
	}

	public VueEquipe getVueEquipe() {
		return vueEquipe;
	}

	public VueListeEquipe getVueListeEquipe() {
		return vueListeEquipe;
	}
	
	public void naviguerVersVueAjouterEquipe() {
		stade.setScene(this.vueAjouterEquipe);
		stade.show();
	}

	public void naviguerVersVueEquipe() {
		stade.setScene(this.vueEquipe);
		stade.show();
	}
	
	public void naviguerVersVueListeEquipe() {
		stade.setScene(this.vueListeEquipe);
		stade.show();
	}

}
