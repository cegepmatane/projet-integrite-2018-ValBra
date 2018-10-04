package donnees;

public interface JoueurSQL {
	public static final String SQL_LISTER_JOUEURS_PAR_EQUIPES = "SELECT * FROM joueurs WHERE equipe = ?";
	public static final String SQL_AJOUTER_JOUEURS = "INSERT into joueurs(nom, age, poste) VALUES(?,?,?)";
}
