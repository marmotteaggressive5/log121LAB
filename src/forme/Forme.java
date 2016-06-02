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

public abstract class Forme {

	private int nSeq;
	private String type;
	private Color color;

	/**
	 * Constructeur
	 * 
	 * @param aNSeq int le numero de sequence
	 * @param aType String le type de la forme
	 * @param aColor Color la couleur de la forme
	 */
	public Forme(final int aNSeq, final String aType, final Color aColor) {
		this.nSeq = aNSeq;
		this.type = aType;
		this.color = aColor;
	}

	/**
	 * 
	 * @return le numero de sequence
	 */
	public int getNSeq() {
		return nSeq;
	}

	/**
	 * 
	 * @return le type de la forme
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @return la couleur de la forme
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Affiche la forme actuelle
	 * 
	 * @param graph qui permet de dessiner les formes
	 */
	public abstract void dessinerForme(Graphics graph);
}
