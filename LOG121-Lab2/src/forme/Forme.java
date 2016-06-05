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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

public abstract class Forme {

	private int nSeq;
	private String type;
	private Color color;

	/**
	 * Constructeur
	 * 
	 * @param aNSeq
	 *            int le numero de sequence
	 * @param aType
	 *            String le type de la forme
	 * @param aColor
	 *            Color la couleur de la forme
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
	 * 
	 * @return la hauteur de la forme
	 */
	public abstract int getHeight();

	/**
	 * 
	 * @return la hauteur de la forme
	 */
	public abstract int getWidth();

	/**
	 * 
	 * @return la premiere coordonnee en x
	 */
	public abstract int getX1();

	/**
	 * 
	 * @return la premiere coordonnee en y
	 */
	public abstract int getY1();

	/**
	 * Affiche la forme actuelle
	 * 
	 * @param graph
	 *            qui permet de dessiner les formes
	 */
	public abstract Forme dessinerForme(Graphics graph);

	/**
	 * Dessine le contour de la forme en pointille
	 * 
	 * @param graph
	 *            qui permet de dessiner les formes
	 */
	public void dessinerContour(Graphics2D graph) {
		graph.setColor(Color.GRAY);

		/*
		 * CODE EMPRUNTE : Les lignes suivantes sont basees sur une fonction
		 * provenant du site :
		 * http://www.java2s.com/Code/Java/2D-Graphics-GUI/Dashedrectangle.htm
		 * 
		 * ce code permet de dessiner le contour de la forme en pointille
		 */

		Rectangle2D contour = getContour();
		float[] dash = { 5, 5 };
		Stroke dashedStroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 3, dash, 0);
		graph.fill(dashedStroke.createStrokedShape(contour));

		/* FIN DU CODE EMPRUNTE */
	}

	/**
	 * Permet d'obtenir le contour de la forme
	 */
	public Rectangle2D getContour() {
		return new Rectangle2D.Float(getX1(), getY1(), getWidth(), getHeight());
	}
}
