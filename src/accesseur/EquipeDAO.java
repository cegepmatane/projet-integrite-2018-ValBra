package accesseur;

import java.util.ArrayList;
import java.util.List;
import modele.Equipe;
import modele.Joueur;

public class EquipeDAO {

	public List<Equipe> montrerListeEquipe(){
		
		List<Joueur> listeJoueursNancy = new ArrayList<Joueur>();
		listeJoueursNancy.add(new Joueur("Chernik","31","gardien"));
		
		List listeEquipe = new ArrayList<Equipe>();
		listeEquipe.add(new Equipe("AS Nancy", "France", "1967", "Marcel Picot","Didier Tholot",listeJoueursNancy));
		listeEquipe.add(new Equipe("Impact Montréal", "Canada", "1992", "Saputo","Rémi Garde"));
		listeEquipe.add(new Equipe("Celtic Glasgow", "Ecosse", "1892", "Celtic Park","Brendan Rogers"));
		return listeEquipe;
	}
}
