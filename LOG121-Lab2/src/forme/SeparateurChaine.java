/******************************************************
Cours:   LOG121
Session: E2016
Groupe:  02
Projet: Laboratoire #1
Étudiant(e)s: Philippe Torres-Brisebois
Professeur : Françis Cardinal
Nom du fichier: SeparateurChaine.java
Date cree: 2016-05-14
Date dern. modif. 2016-05-14
 *******************************************************
Historique des modifications
 *******************************************************
2016-05-14 Version initiale
 *******************************************************/

package forme;

public class SeparateurChaine {

	private final static int LONGUEUR_NUMERO_DE_SEQUENCE = 5;
	private final static int POSITION_DEPART = 0;

	/**
	 * Constructeur
	 */
	public SeparateurChaine() {

	}

	/**
	 * Obtient le numero de sequence de la chaine de carateres
	 * 
	 * @param chaineForme la chaine de characteres
	 * @return int le numero de sequence
	 */
	public int extractNSeq(final String chaineForme) {
		return Integer.parseInt(chaineForme.substring(POSITION_DEPART,
				LONGUEUR_NUMERO_DE_SEQUENCE));
	}

	/**
	 * Obtient le type de forme de la chaine de carateres
	 * 
	 * @param chaineForme la chaine de characteres
	 * @return String le type de la forme
	 */
	public String extractType(final String chaineForme) {
		return chaineForme.substring(chaineForme.indexOf("<") + 1,
				chaineForme.indexOf(">"));
	}

	/**
	 * Obtient les  parametres de la forme dans la chaine de carateres
	 * 
	 * @param chaineForme la chaine de characteres
	 * @return String les parametres de la forme
	 */
	private String extractStringParametres(final String chaineForme) {
		return chaineForme.substring(chaineForme.indexOf(">") + 2,
				chaineForme.indexOf(" </"));
	}

	/**
	 * Obtient les  parametres de la forme dans la chaine de carateres
	 * 
	 * @param chaineForme la chaine de characteres
	 * @return un tableau de int qui contient les parametres de la forme
	 */
	public int[] extractIntParametres(final String chaineForme) {
		String[] stringCoordonnee = extractStringParametres(chaineForme).split(
				" ");
		int[] coordonnee = new int[stringCoordonnee.length];

		for (int i = POSITION_DEPART; i < stringCoordonnee.length; i++) {
			coordonnee[i] = Integer.parseInt(stringCoordonnee[i]);
		}

		return coordonnee;
	}
}
