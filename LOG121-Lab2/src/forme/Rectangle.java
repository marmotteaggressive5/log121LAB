package forme;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends FormeLineaire {

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
	public Rectangle(final int aNSeq, final String aType, final int aX1,
			final int aY1, final int aX2, final int aY2, final Color aColor) {
		super(aNSeq, aType, aX1, aY1, aX2, aY2, aColor);
	}

	/**
	 * Retourne la largeur de la forme
	 * 
	 * @return int la largeur de la forme
	 */
	public int getWidth() {
		return Math.abs(getX2() - getX1());
	}

	/**
	 * Retourne la hauteur de la forme
	 * 
	 * @return int la hauteur de la forme
	 */
	public int getHeight() {
		return Math.abs(getY2() - getY1());
	}
	
	@Override
	public Forme dessinerForme(Graphics graph,int index) {
		graph.setColor(getColor());
		graph.fillRect(DISTANCE_ENTRE_FORME*index, DISTANCE_ENTRE_FORME*index, getWidth(), getHeight());
		return this;
	}

	@Override
	public int getAire() {
		return getWidth()*getHeight();
	}
}
