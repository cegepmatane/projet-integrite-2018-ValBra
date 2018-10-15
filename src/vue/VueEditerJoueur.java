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

public class VueEditerJoueur extends Scene {
	protected TextField valeurNom;
	protected TextField valeurAge;
	protected TextField valeurPoste;
	
	private ControleurEquipe controleur = null;
	protected Button actionEnregistrerJoueur = null;
	private int idJoueur = 0;
	protected Button ajouterJoueur = null;
	
	public VueEditerJoueur()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleEquipe = new GridPane();
		this.actionEnregistrerJoueur = new Button("Enregistrer");
		
		this.actionEnregistrerJoueur.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
			public void handle(ActionEvent arg0) {
				controleur.enregistrerJoueur();
			}});
		
		this.ajouterJoueur = new Button("Ajouter un joueur");
		this.ajouterJoueur.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				
			}
		});
		
		valeurNom = new TextField();
		grilleEquipe.add(new Label("Nom: "), 0, 0);
		grilleEquipe.add(valeurNom,1,0);
		valeurAge = new TextField("");
		grilleEquipe.add(new Label("Age: "), 0, 1);
		grilleEquipe.add(valeurAge, 1, 1);
 		valeurPoste = new TextField("");
 		grilleEquipe.add(new Label("Poste: "), 0, 2);
 		grilleEquipe.add(valeurPoste, 1, 2);		
			
		panneau.getChildren().add(new Label("Editer un joueur"));
		panneau.getChildren().add(grilleEquipe);
		panneau.getChildren().add(this.actionEnregistrerJoueur);
		panneau.getChildren().add(this.ajouterJoueur);
	}
	
	public void afficherJoueur(Joueur joueur){
		this.idJoueur = joueur.getId();
		this.valeurNom.setText(joueur.getNom());
		this.valeurAge.setText(joueur.getAge());
		this.valeurPoste.setText(joueur.getPoste());
	}
	
	public Joueur demanderJoueur(){
		Joueur joueur = new Joueur(this.valeurNom.getText(),this.valeurAge.getText(),this.valeurPoste.getText());
		joueur.setId(idJoueur);
		return joueur;
	}

	public void setControleur(ControleurEquipe controleur) {
		this.controleur = controleur;
	}
}
