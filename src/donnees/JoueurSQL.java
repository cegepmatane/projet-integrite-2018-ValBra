package donnees;

public interface JoueurSQL {
	public static final String SQL_LISTER_JOUEURS_PAR_EQUIPES = "SELECT * FROM joueurs WHERE equipe = ?";
}
