package vue;

import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private VueEquipe vueEquipe = new VueEquipe();
	private Stage stade;

	@Override
	public void start(Stage stade) throws Exception {
		this.stade=stade;
		stade.setScene(this.vueEquipe);
		stade.show();
	}

}
