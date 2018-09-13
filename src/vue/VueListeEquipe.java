package vue;

import java.util.ArrayList;
import java.util.List;

import action.ControleurEquipe;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import modele.Equipe;

public class VueListeEquipe extends Scene {
	
	protected GridPane grilleEquipes;
	private ControleurEquipe controleurEquipe;

	public VueListeEquipe() {
		super(new Pane(),400,400);
		Pane panneau = (Pane) this.getRoot();
		grilleEquipes = new GridPane();
		
		panneau.getChildren().add(grilleEquipes);
	}

	public void afficherListeEquipes(List<Equipe> listeEquipes) {
		this.grilleEquipes.getChildren().clear();
		this.grilleEquipes.add(new Label("Nom"),0,0);
		this.grilleEquipes.add(new Label("Pays"),1,0);
		this.grilleEquipes.add(new Label("Année de création"), 2, 0);
		this.grilleEquipes.add(new Label("Stade"), 3, 0);
		this.grilleEquipes.add(new Label("Entraineur"), 4, 0);
		int position=1;
		for(Equipe equipe:listeEquipes) {
			this.grilleEquipes.add(new Label(equipe.getNom()), 0, position);
			this.grilleEquipes.add(new Label(equipe.getPays()), 1, position);
			this.grilleEquipes.add(new Label(equipe.getAnneeDeCreation()), 2, position);
			this.grilleEquipes.add(new Label(equipe.getStade()), 3, position);
			this.grilleEquipes.add(new Label(equipe.getEntraineur()), 4, position);
			position++;
		}
	}
	
	public void setControleur(ControleurEquipe controleurEquipe) {
		this.controleurEquipe = controleurEquipe;
	}
}
