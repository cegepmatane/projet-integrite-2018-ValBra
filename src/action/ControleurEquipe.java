package action;

import vue.NavigateurDesVues;

public class ControleurEquipe {
	private NavigateurDesVues navigateur;
	
	public ControleurEquipe(NavigateurDesVues navigateur) {
		this.navigateur = navigateur;
		navigateur.naviguerVersVueAjouterEquipe();
		navigateur.naviguerVersVueEquipe();
		navigateur.naviguerVersVueListeEquipe();
	}
}
