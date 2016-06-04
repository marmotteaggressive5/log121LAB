package forme;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

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
	public Forme dessinerForme(Graphics graph) {
		graph.setColor(getColor());
		graph.drawLine(getX1(), getY1(), getX2(), getY2());
		return this;
	}

	@Override
	public int getHeight() {
		int height = getY2() - getY1();
		if (height >=0) {
			return height;
		} else {
			return -height;
		}
	}

	@Override
	public int getWidth() {
		int width = getX2() - getX1();
		if (width >=0) {
			return width;
		} else {
			return -width;
		}
	}
	
	@Override
	public Rectangle2D getContour(){
		int width = getX2() - getX1();
		int height = getY2()-getY1();
		int x1 = getX1();
		int y1 = getY1();
		
		if (width < 0) {
			x1 = getX2();
		}
		
		if (height < 0) {
			y1 = getY2();
		}
		
		return new Rectangle2D.Float( x1, y1, getWidth(), getHeight());
	}
}
