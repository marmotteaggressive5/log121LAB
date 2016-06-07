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

import java.awt.Color;
import java.awt.Point;

public abstract class AbstractFormeLineaire extends AbstractForme {

	private Point point1;
	private Point point2;

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
	public AbstractFormeLineaire(final int aNSeq, final String aType, final int aX1,
			final int aY1, final int aX2, final int aY2, final Color aColor) {
		super(aNSeq, aType, aColor);
		point1 = new Point(aX1,aY1);
		point2 = new Point(aX2,aY2);
		
	}

	public int getX1() {
		return (int) point1.getX();
	}

	public int getY1() {
		return (int) point1.getY();
	}

	public int getX2() {
		return (int) point2.getX();
	}

	public int getY2() {
		return (int) point2.getY();
	}
	
	
	
}
