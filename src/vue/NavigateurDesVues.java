package vue;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.Equipe;

public class NavigateurDesVues extends Application{
	
	private VueEquipe vueEquipe = new VueEquipe();
	private VueListeEquipe vueListeEquipe = new VueListeEquipe();
	private Stage stade;

	@Override
	public void start(Stage stade) throws Exception {
		this.stade=stade;
		stade.setScene(this.vueListeEquipe);
		stade.show();
	}

	public VueEquipe getVueEquipe() {
		return vueEquipe;
	}

	public VueListeEquipe getVueListeEquipe() {
		return vueListeEquipe;
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
