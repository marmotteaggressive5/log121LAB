package forme;

import java.awt.Color;
import java.awt.Graphics;

public class Ligne extends FormeLineaire {

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
	public Ligne(final int aNSeq, final String aType, final int aX1,
			final int aY1, final int aX2, final int aY2, final Color aColor) {
		super(aNSeq, aType, aX1, aY1, aX2, aY2, aColor);
	}

	@Override
	public void dessinerForme(Graphics graph) {
		graph.setColor(getColor());
		graph.drawLine(getX1(), getY1(), getX2(), getY2());
	}
}
