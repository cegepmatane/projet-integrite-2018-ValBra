package vue;

import java.util.ArrayList;
import java.util.List;

import action.ControleurEquipe;
import javafx.application.*;
import javafx.stage.Stage;
import modele.Equipe;

public class NavigateurDesVues extends Application{
	
	private VueAjouterEquipe vueAjouterEquipe = new VueAjouterEquipe();
	private VueEquipe vueEquipe = new VueEquipe();
	private VueListeEquipe vueListeEquipe = new VueListeEquipe();
	private Stage stade;
	private ControleurEquipe controleur;

	@Override
	public void start(Stage stade) throws Exception {
		this.stade=stade;
		stade.setScene(this.vueEquipe);
		stade.show();
		this.controleur = ControleurEquipe.getInstance();
		controleur.afficherVues(this);
	}
	
	public VueAjouterEquipe getVueAjouterEquipe() {
		return vueAjouterEquipe;
	}

	public VueEquipe getVueEquipe() {
		return vueEquipe;
	}

	public VueListeEquipe getVueListeEquipe() {
		return vueListeEquipe;
	}
	
	public void naviguerVersVueAjouterEquipe() {
		stade.setScene(this.vueAjouterEquipe);
		stade.show();
	}

	public void naviguerVersVueEquipe() {
		stade.setScene(this.vueEquipe);
		stade.show();
	}
	
	public void naviguerVersVueListeEquipe() {
		stade.setScene(this.vueListeEquipe);
		stade.show();
	}

}
