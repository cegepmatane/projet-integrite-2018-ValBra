package vue;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

import action.ControleurEquipe;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modele.Equipe;
import modele.Joueur;
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
	protected GridPane listeJoueurs;
	private ControleurEquipe controleur = null;
	protected Button actionEnregistrerEquipe = null;
	private int idEquipe = 0;
	
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
		
		List<Joueur> effectif = new ArrayList<Joueur>();
		Joueur joueur1 = new Joueur("Chernik","31","gardien");
		effectif.add(joueur1);
		Joueur joueur2 = new Joueur("Diagne","21","défenseur");
		effectif.add(joueur2);
		Joueur joueur3 = new Joueur("Bassi","20","milieu");
		effectif.add(joueur3);
		Joueur joueur4 = new Joueur("Dalé","31","attaquant");
		effectif.add(joueur4);
			
		panneau.getChildren().add(new Label("Editer une équipe"));
		panneau.getChildren().add(grilleEquipe);
		panneau.getChildren().add(this.actionEnregistrerEquipe);
		//panneau.getChildren().add(listeJoueurs);
	}
	
	public void afficherEffectif(List<Joueur> effectif) {
		for(int index=0;index<effectif.size();index++) {
			this.listeJoueurs.add(new Label(effectif.get(index).getNom()+""), 0, index);
			this.listeJoueurs.add(new Label(effectif.get(index).getAge()+""), 1, index);
			this.listeJoueurs.add(new Label(effectif.get(index).getPoste()+""), 2, index);
			index++;
		}
	}
	
	public void afficherEquipe(Equipe equipe)
	{
		this.idEquipe = equipe.getId();
		this.valeurNom.setText(equipe.getNom());
		this.valeurPays.setText(equipe.getPays());
		this.valeurAnneeCreation.setText(equipe.getAnneeDeCreation());
		this.valeurStade.setText(equipe.getStade());
		this.valeurEntraineur.setText(equipe.getEntraineur());
	}
	
	public Equipe demanderEquipe()
	{
		Equipe equipe = new Equipe(this.valeurNom.getText(),this.valeurPays.getText(),this.valeurAnneeCreation.getText(),this.valeurStade.getText(), this.valeurEntraineur.getText());
		equipe.setId(idEquipe);
		return equipe;
	}

	public void setControleur(ControleurEquipe controleur) {
		this.controleur = controleur;
	}
}
