package vue;

import java.awt.TextField;

import action.ControleurEquipe;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modele.Equipe;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class VueEditerEquipe extends Scene{
	
	protected TextField valeurNom;
	protected TextField valeurPays;
	protected TextField valeurAnneeCreation;
	protected TextField valeurStade;
	protected TextField valeurEntraineur;
	
	private ControleurEquipe controleur = null;
	protected Button actionEnregistrerEquipe = null;
	
	public VueEditerEquipe()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleEquipe = new GridPane();
		this.actionEnregistrerEquipe = new Button("Enregistrer");
		
		this.actionEnregistrerEquipe.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.enregistrerEquipe();
				
			}});
		
		valeurNom = new TextField();
		grilleEquipe.add(new Label("Nom: "), 0, 0);
		grilleEquipe.add(valeurNom,1,0);
		valeurPays = new TextField("");
		grilleEquipe.add(new Label("Pays: "), 0, 1);
		grilleEquipe.add(valeurPays, 1, 1);
 		valeurAnneeCreation = new TextField("");
 		grilleEquipe.add(new Label("Année de création: "), 0, 2);
 		grilleEquipe.add(valeurAnneeCreation, 1, 2);		
 		valeurStade = new TextField("");
 		grilleEquipe.add(new Label("Stade: "), 0, 3);
 		grilleEquipe.add(valeurStade, 1, 3);
		valeurEntraineur = new TextField("");
		grilleEquipe.add(new Label("Entraineur: "), 0, 4);
		grilleEquipe.add(valeurEntraineur, 1, 4);
			
		panneau.getChildren().add(new Label("Editer une équipe"));
		panneau.getChildren().add(grilleEquipe);
		panneau.getChildren().add(this.actionEnregistrerEquipe);
	}
	
	public Equipe demanderEquipe()
	{
		Equipe equipe = new Equipe(this.valeurNom.getText(),this.valeurPays.getText(),this.valeurAnneeCreation.getText(),this.valeurStade.getText(), this.valeurEntraineur.getText());
		return equipe;
	}

	public void setControleur(ControleurEquipe controleur) {
		this.controleur = controleur;
	}
}
