package vue;

import action.ControleurEquipe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Joueur;

public class VueAjouterJoueur extends Scene {
	private TextField valeurNom;
	private TextField valeurAge;
	private TextField valeurPoste;
	private ControleurEquipe controleur;
	private Button enregistrerJoueur;

	public VueAjouterJoueur() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleJoueur = new GridPane();
		enregistrerJoueur = new Button("Enregistrer");
		enregistrerJoueur.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				controleur.enregistrerNouveauJoueur();
			}
		});

		valeurNom = new TextField();
		grilleJoueur.add(new Label("Nom : "), 0, 0);
		grilleJoueur.add(valeurNom, 1, 0);
		
		valeurAge = new TextField("");
		grilleJoueur.add(new Label("Age : "), 0, 1);
		grilleJoueur.add(valeurAge, 1, 1);

		valeurPoste = new TextField("");
		grilleJoueur.add(new Label("Poste : "), 0, 2);
		grilleJoueur.add(valeurPoste, 1, 2);
			
		panneau.getChildren().add(new Label("Ajouter un joueur"));
		panneau.getChildren().add(grilleJoueur);
		panneau.getChildren().add(enregistrerJoueur);
	}
	
	public Joueur creerJoueur() {
		Joueur nouveauJoueur = new Joueur(this.valeurNom.getText(),this.valeurAge.getText(),this.valeurPoste.getText());
		return nouveauJoueur;
	}
	
	public void setControleur(ControleurEquipe controleur) {
		this.controleur = controleur;
	}
}
