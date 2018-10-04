package vue;

import java.util.List;

import action.ControleurEquipe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import modele.Equipe;

public class VueListeEquipe extends Scene {
	
	protected GridPane grilleEquipes;
	private ControleurEquipe controleurEquipe = null;
	private Button naviguerVersAjouterEquipe;
	//private Button naviguerVersEditerEquipe;

	public VueListeEquipe() {
		super(new GridPane(),600,400);
		grilleEquipes = (GridPane)this.getRoot();
		this.naviguerVersAjouterEquipe = new Button("Ajouter une équipe");
	}

	public void afficherListeEquipes(List<Equipe> listeEquipes) {
		this.grilleEquipes.getChildren().clear();
		this.grilleEquipes.add(new Label("Nom"),0,0);
		this.grilleEquipes.add(new Label("Pays"),1,0);
		this.grilleEquipes.add(new Label("Année de création"), 2, 0);
		this.grilleEquipes.add(new Label("Stade"), 3, 0);
		//this.grilleEquipes.add(new Label("Entraineur"), 4, 0);
		this.grilleEquipes.add(new Label(""), 4, 0);
		int position=1;
		for(Equipe equipe:listeEquipes) {
			Button naviguerVersEditerEquipe = new Button("Editer");
			naviguerVersEditerEquipe.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					controleurEquipe.notifierNaviguerEditerEquipe(equipe.getId());
				}});
			position++;
			this.grilleEquipes.add(new Label(equipe.getNom()), 0, position);
			this.grilleEquipes.add(new Label(equipe.getPays()), 1, position);
			this.grilleEquipes.add(new Label(equipe.getAnneeDeCreation()), 2, position);
			this.grilleEquipes.add(new Label(equipe.getStade()), 3, position);
			//this.grilleEquipes.add(new Label(equipe.getEntraineur()), 4, position);
			this.grilleEquipes.add(naviguerVersEditerEquipe, 4,position);
		}
		
		this.naviguerVersAjouterEquipe.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				controleurEquipe.notifierNaviguerAjouterEquipe();
			}
			
		});
		this.grilleEquipes.add(this.naviguerVersAjouterEquipe, 1, ++position);
	}
	
	public void setControleur(ControleurEquipe controleurEquipe) {
		this.controleurEquipe = controleurEquipe;
	}
}
