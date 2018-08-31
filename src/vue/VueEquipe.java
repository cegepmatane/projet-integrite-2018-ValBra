package vue;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import modele.Equipe;

public class VueEquipe extends Scene{
	
	Label valeurNom,valeurPays,valeurDateDeCreation,valeurStade,valeurEntraineur;
	//List<Joueur> listeJoueurs;
	
	public VueEquipe() {
		super(new Pane(),400,400);
		Pane panneau = (Pane) this.getRoot();
		
		GridPane grilleEquipe = new GridPane();
		
		valeurNom = new Label();
		grilleEquipe.add(new Label("Nom: "),0,0);
		grilleEquipe.add(valeurNom, 1, 0);
		
		valeurPays = new Label();
		grilleEquipe.add(new Label("Pays: "),0,1);
		grilleEquipe.add(valeurPays, 1, 1);
		
		valeurDateDeCreation = new Label();
		grilleEquipe.add(new Label("Année de création: "),0,2);
		grilleEquipe.add(valeurDateDeCreation, 1, 2);
		
		valeurStade = new Label();
		grilleEquipe.add(new Label("Stade: "),0,3);
		grilleEquipe.add(valeurStade, 1, 3);
		
		valeurEntraineur = new Label();
		grilleEquipe.add(new Label("Entraineur: "),0,4);
		grilleEquipe.add(valeurEntraineur, 1, 4);
		
		panneau.getChildren().add(grilleEquipe);

		//Test
		Equipe equipe1 = new Equipe("AS Nancy","France","1967","Marcel Picot","Didier Tholot");
		this.afficherEquipe(equipe1);
	}
	
	public void afficherEquipe(Equipe equipe) {
		this.valeurNom.setText(equipe.getNom());
		this.valeurPays.setText(equipe.getPays());
		this.valeurDateDeCreation.setText(equipe.getAnneeDeCreation());
		this.valeurStade.setText(equipe.getStade());
		this.valeurEntraineur.setText(equipe.getEntraineur());
	}

}
