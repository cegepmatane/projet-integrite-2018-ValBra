package donnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Equipe;
import modele.Joueur;

public class JoueurDAO implements JoueurSQL{
	private Connection connection = null;
	
	public JoueurDAO() {
		this.connection=BaseDeDonnees.getInstance().getConnection();
	}
	
	public List<Joueur> listerJoueurs(int idEquipe)
	{
		List<Joueur> listeJoueurs =  new ArrayList<Joueur>();			
		PreparedStatement requeteListeJoueurs;
		try {
			requeteListeJoueurs = connection.prepareStatement(SQL_LISTER_JOUEURS_PAR_EQUIPES);
			requeteListeJoueurs.setInt(1, idEquipe);
			ResultSet curseurListeJoueurs = requeteListeJoueurs.executeQuery();
			while(curseurListeJoueurs.next())
			{
				int id = curseurListeJoueurs.getInt("id");
				String nom = curseurListeJoueurs.getString("nom");
				String age = curseurListeJoueurs.getString("age");
				String poste = curseurListeJoueurs.getString("poste");				
				System.out.println(nom+", "+poste+" de "+age+" ans");
				
				Joueur joueur = new Joueur(nom,age,poste);
				joueur.setAge(age);
				joueur.setPoste(poste);
				joueur.setId(id);
				listeJoueurs.add(joueur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeJoueurs;
	}
	
	public void ajouterJoueur(Joueur joueur) {
		try {
			PreparedStatement requeteAjoutEquipe = connection.prepareStatement(SQL_AJOUTER_JOUEURS);
			requeteAjoutEquipe.setString(1, joueur.getNom());
			requeteAjoutEquipe.setString(2, joueur.getAge());
			requeteAjoutEquipe.setString(3, joueur.getPoste());
			requeteAjoutEquipe.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public Joueur rapporterJoueur(int idJoueur) {
		PreparedStatement requeteJoueur;
		try {
			requeteJoueur = connection.prepareStatement(SQL_RAPPORTER_JOUEURS);
			requeteJoueur.setInt(1, idJoueur);
			ResultSet curseurJoueur = requeteJoueur.executeQuery();
			curseurJoueur.next();
			int id = curseurJoueur.getInt("id");
			String nom = curseurJoueur.getString("nom");
			String age = curseurJoueur.getString("age");
			String poste = curseurJoueur.getString("poste");
			System.out.println(nom + ", " + poste + " de " + age);
			Joueur joueur = new Joueur(nom,age,poste);
			joueur.setId(id);
			return joueur;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void modifierJoueur(Joueur joueur) {
		try {
			PreparedStatement requeteModifierJoueur = connection.prepareStatement(SQL_MODIFIER_JOUEURS);
			requeteModifierJoueur.setString(1, joueur.getNom());
			requeteModifierJoueur.setString(2, joueur.getAge());
			requeteModifierJoueur.setString(3, joueur.getPoste());
			requeteModifierJoueur.setInt(4, joueur.getId());
			requeteModifierJoueur.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
