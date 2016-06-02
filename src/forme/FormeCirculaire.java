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
import java.awt.Graphics;

public class FormeCirculaire extends Forme {

	private int centreX;
	private int centreY;
	private int rayonH;
	private int rayonV;

	/**
	 * Constructeur
	 * 
	 * @param aNSeq numero de sequence
	 * @param aType type de la forme
	 * @param aCentreX coordonnee x du centre
	 * @param aCentreY coordonnee y du centre
	 * @param aRayonH rayon horizontal
	 * @param aRayonV rayon vertical
	 * @param aColor la couleur de la forme
	 */
	public FormeCirculaire(final int aNSeq, final String aType,
			final int aCentreX, final int aCentreY, final int aRayonH,
			final int aRayonV, final Color aColor) {
		super(aNSeq, aType, aColor);
		this.centreX = aCentreX;
		this.centreY = aCentreY;
		this.rayonH = aRayonH;
		this.rayonV = aRayonV;

	}

	public int getCentreX() {
		return centreX;
	}

	public int getCentreY() {
		return centreY;
	}

	public int getRayonH() {
		return rayonH;
	}

	public int getRayonV() {
		return rayonV;
	}

	@Override
	public void dessinerForme(Graphics graph) {
		graph.setColor(getColor());
		graph.fillOval(centreX - rayonH, centreY - rayonV, rayonH * 2, rayonV * 2);
	}

}
