/******************************************************
Cours:   LOG121
Session: E2016
Groupe:  02
Projet: Laboratoire #1
Etudiant(e)s: Philippe Torres-Brisebois
			  Nelson Chao
			  Samuel Crotteau
			  Laurent Theroux-Bombardier
Professeur : Françis Cardinal
Nom du fichier: CreateurFormes.java
Date cree: 2016-05-14
Date dern. modif. 2016-05-14
 *******************************************************
Historique des modifications
 *******************************************************
2016-05-14 Version initiale
 *******************************************************/

package forme;

import java.awt.Color;

import ca.etsmtl.log.util.IDLogger;

public class CreateurFormes {
	private final static int CENTREX = 0;
	private final static int CENTREY = 1;
	private final static int RAYON = 2;
	private final static int RAYONH = 2;
	private final static int RAYONV = 3;
	private final static int X1 = 0;
	private final static int Y1 = 1;
	private final static int X2 = 2;
	private final static int Y2 = 3;

	private SeparateurChaine separateur = new SeparateurChaine();
	private IDLogger logger = IDLogger.getInstance();

	public CreateurFormes() {

	}

	/**
	 * Cree une nouvelle forme. Cette methode recoit la chaine de
	 * caracteres provenant du serveur de formes, elle determine de quelle
	 * forme il s'agit et applique l'operateur new sur le constructeur de la
	 * forme desiree.
	 *
	 * @param chaineForme
	 *            un objet String contenant la chaine de caracteres qui
	 *            decrit une forme et provenant du serveur de formes.
	 *
	 * @return une instance d'une des sous-classes de la classe abstraite Forme
	 *         avec les parametres passes par la chaine d'entree.
	 */
	public AbstractForme creerForme(final String chaineForme) {

		int nSeq = separateur.extractNSeq(chaineForme);
		String type = separateur.extractType(chaineForme);
		int[] coordonnee = separateur.extractIntParametres(chaineForme);

		logger.logID(nSeq); // Ajoute le numero de sequence au IDLogger

		// selon le type cree la forme avec une couleur specifique et ajoute ses
		// coordonnees
		switch (type) {
		case "RECTANGLE":
			return new Rectangle(nSeq, type, coordonnee[X1], coordonnee[Y1],
					coordonnee[X2], coordonnee[Y2], Color.BLUE);
		case "CARRE":
			return new Rectangle(nSeq, type, coordonnee[X1], coordonnee[Y1],
					coordonnee[X2], coordonnee[Y2], Color.RED);
		case "LIGNE":
			return new Ligne(nSeq, type, coordonnee[X1], coordonnee[Y1],
					coordonnee[X2], coordonnee[Y2], Color.BLACK);
		case "OVALE":
			return new FormeCirculaire(nSeq, type, coordonnee[CENTREX],
					coordonnee[CENTREY], coordonnee[RAYONH],
					coordonnee[RAYONV], Color.CYAN);
		case "CERCLE":
			return new FormeCirculaire(nSeq, type, coordonnee[CENTREX],
					coordonnee[CENTREY], coordonnee[RAYON], coordonnee[RAYON],
					Color.ORANGE);
		default:
			return null;
		}
	}
}
