package donnees;

public interface EquipeSQL {
	public static final String SQL_LISTER_EQUIPES = "SELECT * FROM equipes";
	public static final String SQL_AJOUTER_EQUIPES = "INSERT into equipes(nom, pays, annee, stade, entraineur) VALUES(?,?,?,?,?)";
	public static final String SQL_MODIFIER_EQUIPES = "UPDATE equipes SET nom = ?, pays = ?, annee = ?, stade = ?, entraineur = ? WHERE id = ?";
	public static final String SQL_RAPPORTER_EQUIPES = "SELECT * FROM equipes WHERE id = ?";
}
