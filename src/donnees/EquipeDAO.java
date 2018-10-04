package donnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.Equipe;

public class EquipeDAO implements EquipeSQL {
	Connection connexion = null;
	
	public EquipeDAO(){
		this.connexion = BaseDeDonnees.getInstance().getConnection();		
	}

	public List<Equipe> montrerListeEquipe(){
		
		List<Equipe> listeEquipe =  new ArrayList<Equipe>();
		try {
 			Statement requeteListeEquipe = connexion.createStatement();
 			ResultSet curseurListeEquipes = requeteListeEquipe.executeQuery(SQL_LISTER_EQUIPES);
 			while(curseurListeEquipes.next()) {
 				int id = curseurListeEquipes.getInt("id");
 	 			String nom = curseurListeEquipes.getString("nom");
 	 			String pays = curseurListeEquipes.getString("pays");
 	 			String stade = curseurListeEquipes.getString("stade");
 	 			String anneeCreation = curseurListeEquipes.getString("annee");
 	 			String coach = curseurListeEquipes.getString("entraineur");
 	 			System.out.println(nom+", équipe de "+pays+" créée en "+anneeCreation+", joue au stade "+stade+" et est entrainée par "+coach);
 	 			Equipe equipe = new Equipe(nom,pays,anneeCreation,stade,coach);
 	 			equipe.setId(id);
 	 			listeEquipe.add(equipe);
 			}
 		}catch(SQLException e) {
 			e.printStackTrace();
 		}
		return listeEquipe;
	}
	
	public void ajouterEquipe(Equipe equipe) {
		try {
			PreparedStatement requeteAjoutEquipe = connexion.prepareStatement(SQL_AJOUTER_EQUIPES);
			requeteAjoutEquipe.setString(1, equipe.getNom());
			requeteAjoutEquipe.setString(2, equipe.getPays());
			requeteAjoutEquipe.setString(3, equipe.getAnneeDeCreation());
			requeteAjoutEquipe.setString(4, equipe.getStade());
			requeteAjoutEquipe.setString(5, equipe.getEntraineur());
			requeteAjoutEquipe.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public Equipe rapporterEquipe(int idEquipe) {
		PreparedStatement requeteEquipe;
		try {
			requeteEquipe = connexion.prepareStatement(SQL_RAPPORTER_EQUIPES);
			requeteEquipe.setInt(1, idEquipe);
			ResultSet curseurEquipe = requeteEquipe.executeQuery();
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
			PreparedStatement requeteModifierEquipe = connexion.prepareStatement(SQL_MODIFIER_EQUIPES);
			requeteModifierEquipe.setString(1, equipe.getNom());
			requeteModifierEquipe.setString(2, equipe.getPays());
			requeteModifierEquipe.setString(3, equipe.getAnneeDeCreation());
			requeteModifierEquipe.setString(4, equipe.getStade());
			requeteModifierEquipe.setString(5, equipe.getEntraineur());
			requeteModifierEquipe.setInt(6, equipe.getId());
			requeteModifierEquipe.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
