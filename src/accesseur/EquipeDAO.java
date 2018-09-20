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
	Connection connexion = null;

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
	
	public EquipeDAO() {
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void accesBaseDeDonnees() {
 		try {
 			Statement requeteListeEquipes = connexion.createStatement();
 			ResultSet curseurListeEquipes = requeteListeEquipes.executeQuery("SELECT * FROM equipes");
 			curseurListeEquipes.next();
 			if(curseurListeEquipes.next()) {
 				int id = curseurListeEquipes.getInt("id");
 	 			String nom = curseurListeEquipes.getString("nom");
 	 			String pays = curseurListeEquipes.getString("pays");
 	 			String stade = curseurListeEquipes.getString("stade");
 	 			String anneeCreation = curseurListeEquipes.getString("anneeCreation");
 	 			String coach = curseurListeEquipes.getString("entraineur");
 	 			System.out.println(nom+", équipe de "+pays+" créée en "+anneeCreation+", joue au stade "+stade+" et est entrainée par "+coach);
 	 			Equipe equipe = new Equipe(nom,pays,anneeCreation,stade,coach);
 	 			equipe.setId(id);
 			}
 		}catch(SQLException e) {
 			e.printStackTrace();
 		}
	}
	
	public void ajouterEquipe(Equipe equipe) {
		try {
			Statement requeteAjoutEquipe = connexion.createStatement();
			String sqlAjouterEquipe = "INSERT into equipes(nom,pays,annee,stade,entraineur) VALUES('"+equipe.getNom()+"','"+equipe.getPays()+"','"+equipe.getAnneeDeCreation()+"','"+equipe.getStade()+"','"+equipe.getEntraineur()+"')";
			requeteAjoutEquipe.execute(sqlAjouterEquipe);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public Equipe rapporterEquipe(int idEquipe) {
		Statement requeteEquipe;
		try {
			requeteEquipe = connexion.createStatement();
			String SQL_RAPPORTER_EQUIPES = "SELECT * FROM equipes WHERE id = " + idEquipe;
			System.out.println(SQL_RAPPORTER_EQUIPES);
			ResultSet curseurEquipe = requeteEquipe.executeQuery(SQL_RAPPORTER_EQUIPES);
			curseurEquipe.next();
			int id = curseurEquipe.getInt("id");
			String nom = curseurEquipe.getString("nom");
			String pays = curseurEquipe.getString("pays");
			String anneeCreation = curseurEquipe.getString("annee");
			String stade = curseurEquipe.getString("stade");
			String entraineur = curseurEquipe.getString("entraineur");
			System.out.println(nom + ", équipe de " + pays + " créée en " + anneeCreation + " joue à " + stade + " et est entrainée par " + entraineur);
			Equipe equipe = new Equipe(nom, pays, anneeCreation, stade, entraineur);
			equipe.setId(id);
			return equipe;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void modifierEquipe(Equipe equipe) {
		try {
			Statement requeteModifierEquipe = connexion.createStatement();
			String SQL_MODIFIER_EQUIPE = "UPDATE equipes SET nom = '"+equipe.getNom()+"', pays = '"+equipe.getPays()+"', annee = '"+equipe.getAnneeDeCreation()+"', naissance = '"+equipe.getStade()+"', entraineur = '"+equipe.getEntraineur()+"' WHERE id = " + equipe.getId();
			requeteModifierEquipe.execute(SQL_MODIFIER_EQUIPE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
