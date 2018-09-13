package vue;

import action.ControleurEquipe;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class VueAjouterEquipe extends Scene{
	private TextField valeurNom;
	private TextField valeurPays;
	private TextField valeurAnneeDeCreation;
	private TextField valeurStade;
	private TextField valeurEntraineur;
	private ControleurEquipe controleurEquipe;

	public VueAjouterEquipe() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleEquipe = new GridPane();

		valeurNom = new TextField();
		grilleEquipe.add(new Label("Nom : "), 0, 0);
		grilleEquipe.add(valeurNom, 1, 0);
		
		valeurPays = new TextField("");
		grilleEquipe.add(new Label("Pays : "), 0, 1);
		grilleEquipe.add(valeurPays, 1, 1);

		valeurAnneeDeCreation = new TextField("");
		grilleEquipe.add(new Label("Annee de création : "), 0, 2);
		grilleEquipe.add(valeurAnneeDeCreation, 1, 2);		

		valeurStade = new TextField("");
		grilleEquipe.add(new Label("Stade : "), 0, 3);
		grilleEquipe.add(valeurStade, 1, 3);
		
		valeurEntraineur = new TextField("");
		grilleEquipe.add(new Label("Entraineur : "), 0, 4);
		grilleEquipe.add(valeurEntraineur, 1, 4);
			
		panneau.getChildren().add(new Label("Ajouter une équipe"));
		panneau.getChildren().add(grilleEquipe);
		panneau.getChildren().add(new Button("Enregistrer"));
	}
	
	public void setControleur(ControleurEquipe controleurEquipe) {
		this.controleurEquipe = controleurEquipe;
	}

}
