package donnees;

public interface JoueurSQL {
	public static final String SQL_LISTER_JOUEURS_PAR_EQUIPES = "SELECT * FROM joueurs WHERE equipe = ?";
	public static final String SQL_AJOUTER_JOUEURS = "INSERT into joueurs(nom, age, poste) VALUES(?,?,?)";
	public static final String SQL_MODIFIER_JOUEURS = "UPDATE joueurs SET nom = ?, age = ?, poste = ? WHERE id = ?";
	public static final String SQL_RAPPORTER_JOUEURS = "SELECT * FROM joueurs WHERE id = ?";
}
