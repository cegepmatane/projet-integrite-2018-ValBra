package accesseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Joueur;

public class JoueurDAO {
	private static String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
	private static String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/equipes";
	private static String BASEDEDONNEES_USAGER = "postgres";
	private static String BASEDEDONNEES_MOTDEPASSE = "valere";	
	private Connection connection = null;
	
	public JoueurDAO() {
		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Joueur> listerJoueurs()
	{
		List<Joueur> listeJoueurs =  new ArrayList<Joueur>();			
		Statement requeteListeJoueurs;
		try {
			requeteListeJoueurs = connection.createStatement();
			ResultSet curseurListeJoueurs = requeteListeJoueurs.executeQuery("SELECT * FROM joueurs WHERE equipes = 2");
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
				listeJoueurs.add(joueur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerDistinctions();
		return listeJoueurs;
	}
}
