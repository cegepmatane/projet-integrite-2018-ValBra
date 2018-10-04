package vue;

import action.ControleurEquipe;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Equipe;

public class VueEquipe extends Scene{
	
	Label valeurNom,valeurPays,valeurDateDeCreation,valeurStade,valeurEntraineur;
	private ControleurEquipe controleurEquipe = null;
	
	public VueEquipe() {
		super(new GridPane(),400,400);
		GridPane grilleEquipe = (GridPane)this.getRoot();
		
		valeurNom = new Label();
		grilleEquipe.add(new Label("Nom: "), 0, 0);
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
	}
	
	public void afficherEquipe(Equipe equipe) {
		this.valeurNom.setText(equipe.getNom());
		this.valeurPays.setText(equipe.getPays());
		this.valeurDateDeCreation.setText(equipe.getAnneeDeCreation());
		this.valeurStade.setText(equipe.getStade());
		this.valeurEntraineur.setText(equipe.getEntraineur());
	}
	
	public void setControleur(ControleurEquipe controleurEquipe) {
		this.controleurEquipe = controleurEquipe;
	}

}
