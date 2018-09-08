package vue;

import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import modele.Equipe;
import modele.Joueur;

public class VueEquipe extends Scene{
	
	Label valeurNom,valeurPays,valeurDateDeCreation,valeurStade,valeurEntraineur;
	GridPane grilleEquipe;
	
	public VueEquipe() {
		super(new Pane(),400,400);
		Pane panneau = (Pane) this.getRoot();
		
		grilleEquipe = new GridPane();
		
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
		
		grilleEquipe.add(new Label("Liste des joueurs: "), 0, 5);
		grilleEquipe.add(new Label("Nom"), 1, 5);
		grilleEquipe.add(new Label("Poste"), 2, 5);
		grilleEquipe.add(new Label("Age"), 3, 5);
		
		/*for(int indexListeJoueurs=0; indexListeJoueurs<listeJoueurs.size();indexListeJoueurs++) {
			grilleEquipe.add(new Label(listeJoueurs.get(indexListeJoueurs).getNom()), 1, indexListeJoueurs+6);
			grilleEquipe.add(new Label(listeJoueurs.get(indexListeJoueurs).getPoste()), 2, indexListeJoueurs+6);
			grilleEquipe.add(new Label(listeJoueurs.get(indexListeJoueurs).getAge()), 3, indexListeJoueurs+6);
		}*/
		
		panneau.getChildren().add(grilleEquipe);
	}
	
	public void afficherEquipe(Equipe equipe) {
		this.valeurNom.setText(equipe.getNom());
		this.valeurPays.setText(equipe.getPays());
		this.valeurDateDeCreation.setText(equipe.getAnneeDeCreation());
		this.valeurStade.setText(equipe.getStade());
		this.valeurEntraineur.setText(equipe.getEntraineur());
		
		if(!equipe.getListeJoueurs().isEmpty()) {
			for(int indexListeJoueurs=0; indexListeJoueurs<equipe.getListeJoueurs().size();indexListeJoueurs++) {
				grilleEquipe.add(new Label(equipe.getListeJoueurs().get(indexListeJoueurs).getNom()), 1, indexListeJoueurs+6);
				grilleEquipe.add(new Label(equipe.getListeJoueurs().get(indexListeJoueurs).getPoste()), 2, indexListeJoueurs+6);
				grilleEquipe.add(new Label(equipe.getListeJoueurs().get(indexListeJoueurs).getAge()), 3, indexListeJoueurs+6);
			}
		}
		
	}

}
