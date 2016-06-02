/******************************************************
Cours:   LOG121
Session: E2016
Groupe:  02
Projet: Laboratoire #1
Étudiant(e)s: Philippe Torres-Brisebois
Professeur : Françis Cardinal
Nom du fichier: Forme.java
Date créé: 2016-05-14
Date dern. modif. 2016-05-14
 *******************************************************
Historique des modifications
 *******************************************************
2016-05-14 Version initiale
 *******************************************************/

package forme;

import java.awt.Color;

public abstract class FormeLineaire extends Forme {

	private int x1;
	private int x2;
	private int y1;
	private int y2;

	/**
	 * Constructeur
	 * 
	 * @param aNSeq le numero de sequence
	 * @param aType le type de la forme
	 * @param aX1 la premiere coordonnee x
	 * @param aY1 la premiere coordonnee y
	 * @param aX2 la deuxieme coordonnee x
	 * @param aY2 la deuxieme coordonnee y
	 * @param aColor la couleur de la forme
	 */
	public FormeLineaire(final int aNSeq, final String aType, final int aX1,
			final int aY1, final int aX2, final int aY2, final Color aColor) {
		super(aNSeq, aType, aColor);
		this.x1 = aX1;
		this.y1 = aY1;
		this.x2 = aX2;
		this.y2 = aY2;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	/**
	 * Retourne la largeur de la forme
	 * 
	 * @return int la largeur de la forme
	 */
	public int getWidth() {
		return getX2() - getX1();
	}

	/**
	 * Retourne la hauteur de la forme
	 * 
	 * @return int la hauteur de la forme
	 */
	public int getHeight() {
		return getY2() - getY1();
	}
}
