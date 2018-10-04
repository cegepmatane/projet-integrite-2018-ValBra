package vue;

import action.ControleurEquipe;
import javafx.application.*;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private VueAjouterEquipe vueAjouterEquipe = new VueAjouterEquipe();
	private VueEditerEquipe vueEditerEquipe = new VueEditerEquipe();
	private VueEquipe vueEquipe = new VueEquipe();
	private VueListeEquipe vueListeEquipe = new VueListeEquipe();
	private VueAjouterJoueur vueAjouterJoueur = new VueAjouterJoueur();
	private VueEditerJoueur vueEditerJoueur = new VueEditerJoueur();
	private Stage stade;
	private ControleurEquipe controleur;
	
	public NavigateurDesVues() {
		this.vueAjouterEquipe = new VueAjouterEquipe();
		this.vueEquipe = new VueEquipe();
		this.vueEditerEquipe = new VueEditerEquipe();
		this.vueListeEquipe = new VueListeEquipe();
		this.vueAjouterJoueur = new VueAjouterJoueur();
		this.vueEditerJoueur = new VueEditerJoueur();
	}

	@Override
	public void start(Stage stade) throws Exception {
		this.stade=stade;
		//stade.setScene(this.vueListeEquipe);
		stade.setScene(null);
		stade.show();
		this.controleur = ControleurEquipe.getInstance();
		controleur.afficherVues(this);
		this.vueAjouterEquipe.setControleur(controleur);
		this.vueEquipe.setControleur(controleur);
		this.vueListeEquipe.setControleur(controleur);
		this.vueEditerEquipe.setControleur(controleur);
	}
	
	public VueEditerEquipe getVueEditerEquipe() {
		return vueEditerEquipe;
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
	
	public VueAjouterJoueur getVueAjouterJoueur() {
		return vueAjouterJoueur;
	}
	
	public VueEditerJoueur getVueEditerJoueur() {
		return vueEditerJoueur;
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
	
	public void naviguerVersVueEditerEquipe()
	{
		stade.setScene(this.vueEditerEquipe);
		stade.show();				
	}

	public void naviguerVersVueAjouterJoueur() {
		stade.setScene(this.vueAjouterJoueur);
		stade.show();
	}
	
	public void naviguerVersVueEditerJoueur() {
		stade.setScene(this.vueEditerJoueur);
		stade.show();
	}
}
