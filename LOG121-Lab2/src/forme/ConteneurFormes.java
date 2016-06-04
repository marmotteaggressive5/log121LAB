/******************************************************
Cours:   LOG121
Session: E2016
Groupe:  02
Projet: Laboratoire #1
�tudiant(e)s: Philippe Torres-Brisebois
Professeur : Fran�is Cardinal
Nom du fichier: Forme.java
Date cr��: 2016-05-14
Date dern. modif. 2016-05-14
 *******************************************************
Historique des modifications
 *******************************************************
2016-05-14 Version initiale
 *******************************************************/

package forme;

public class ConteneurFormes {

	private final static int MAX_FORMES = 10;

	private Forme[] formeArray = new Forme[MAX_FORMES];

	/**
	 * Constructeur
	 */
	public ConteneurFormes() {

	}

	/**
	 * ajoute une forme dans le tableau de forme
	 * 
	 * @param aForme une forme a ajouter
	 */
	public void addForme(final Forme aForme) {
		for (int i = 0; i < formeArray.length; i++) {
			if (formeArray[i] == null) {
				formeArray[i] = aForme;
				return;
			}
		}
		updateFormeArray(aForme);
	}

	/**
	 * Met a jour le tableau de forme afin qu'il contienne au maximum 10 formes
	 * 
	 * @param aForme une forme a ajouter
	 */
	private void updateFormeArray(final Forme aForme) {

		for (int i = 0; i < formeArray.length; i++) {

			if (i == formeArray.length - 1) {
				formeArray[i] = aForme;
				break;
			}

			formeArray[i] = formeArray[i + 1];
		}
	}

	/**
	 * vide le tableau de forme
	 */
	public void clearForme() {
		this.formeArray = new Forme[MAX_FORMES];
	}

	/**
	 * Retourne le tableau de forme 
	 * 
	 * @return un tableau de forme
	 */
	public Forme[] getFormeArray() {
		return formeArray;
	}

}
