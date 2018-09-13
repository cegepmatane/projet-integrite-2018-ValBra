package accesseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.Equipe;
import modele.Joueur;

public class EquipeDAO {
	Connection connexion;

	public List<Equipe> montrerListeEquipe(){
		
		//Test
		/*List<Joueur> listeJoueursNancy = new ArrayList<Joueur>();
		listeJoueursNancy.add(new Joueur("Chernik","31","gardien"));*/
		
		List listeEquipe = new ArrayList<Equipe>();
		listeEquipe.add(new Equipe("AS Nancy", "France", "1967", "Marcel Picot","Didier Tholot"));
		listeEquipe.add(new Equipe("Impact Montréal", "Canada", "1992", "Saputo","Rémi Garde"));
		listeEquipe.add(new Equipe("Celtic Glasgow", "Ecosse", "1892", "Celtic Park","Brendan Rogers"));
		return listeEquipe;
	}
	
	public void accesBaseDeDonnees() {
		String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
 		String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/equipes";
 		String BASEDEDONNEES_USAGER = "postgres";
 		String BASEDEDONNEES_MOTDEPASSE = "valere";
 		
 		try {
 			Class.forName(BASEDEDONNEES_DRIVER);
 		} catch (ClassNotFoundException e) {
 			e.printStackTrace();
		}
 		
 		try {
 			this.connexion = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
 			Statement requeteListeEquipes = connexion.createStatement();
 			ResultSet curseurListeEquipes = requeteListeEquipes.executeQuery("SELECT * FROM equipes");
 			curseurListeEquipes.next();
 			if(curseurListeEquipes.next()) {
 	 			String nom = curseurListeEquipes.getString("nom");
 	 			String pays = curseurListeEquipes.getString("pays");
 	 			String stade = curseurListeEquipes.getString("stade");
 	 			String anneeCreation = curseurListeEquipes.getString("anneeCreation");
 	 			String coach = curseurListeEquipes.getString("entraineur");
 	 			System.out.println(nom+", équipe de "+pays+" créée en "+anneeCreation+", joue au stade "+stade+" et est entrainée par "+coach);
 			}
 		}catch(SQLException e) {
 			e.printStackTrace();
 		}
	}
	
	public void ajouterEquipe(Equipe equipe) {
		try {
			Statement requeteAjoutEquipe = connexion.createStatement();
			String sqlAjouterEquipe = "INSERT into equipes(nom,pays,anneeCreation,stade,entraineur) VALUES('"+equipe.getNom()+"','"+equipe.getPays()+"','"+equipe.getAnneeDeCreation()+"','"+equipe.getStade()+"','"+equipe.getEntraineur()+"')";
			requeteAjoutEquipe.execute(sqlAjouterEquipe);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
