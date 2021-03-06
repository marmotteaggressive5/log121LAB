/******************************************************
Cours:   LOG121
Session: E2016
Groupe:  02
Projet: Laboratoire #1
Etudiant(e)s: Philippe Torres-Brisebois
			  Nelson Chao
			  Samuel Crotteau
			  Laurent Theroux-Bombardier
Professeur : Francis Cardinal
Nom du fichier: FormeCirculaire.java
Date cree 2016-05-14
Date dern. modif. 2016-05-14
 *******************************************************
Historique des modifications
 *******************************************************
2016-05-14 Version initiale
 *******************************************************/

package forme;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class FormeCirculaire extends AbstractForme {

	private Point centre;
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
		
		centre = new Point(aCentreX,aCentreY);
		
		this.rayonH = aRayonH;
		this.rayonV = aRayonV;

	}

	/**
	 * 
	 * @return la coordonne x du centre de la forme
	 */
	public int getCentreX() {
		return (int) centre.getX();
	}

	/**
	 * 
	 * @return la coordonne y du centre de la forme
	 */
	public int getCentreY() {
		return (int) centre.getY();
	}

	/**
	 * 
	 * @return la longueur du rayon horizontal
	 */
	public int getRayonH() {
		return rayonH;
	}

	/**
	 * 
	 * @return la longueur du rayon vertical
	 */
	public int getRayonV() {
		return rayonV;
	}
	
	

	@Override
	public AbstractForme dessinerForme(Graphics graph,int index) {
		graph.setColor(getColor());
		graph.fillOval(DISTANCE_ENTRE_FORME*index, DISTANCE_ENTRE_FORME*index, getWidth(), getHeight());
		return this;
	}

	

	@Override
	public int getHeight() {
		return this.rayonV*2;
	}

	@Override
	public int getWidth() {
		return this.rayonH*2;
	}

	public int getX1(){
		return getCentreX()-getRayonH();
	}
	
	public int getY1(){
		return getCentreY()-getRayonV();
	}

	@Override
	public int getAire() {
		return (int) (Math.PI * getRayonH() * getRayonV());
	}

	@Override
	public int getDistanceMax() {
		int result;
		if(getWidth() > getHeight()){
			result = getWidth();
		}else{
			result = getHeight();
		}
		return result;
	}

	@Override
	public AbstractForme dessinerFormeOriginal(Graphics graph) {
		graph.setColor(getColor());
		graph.fillOval(getCentreX() - rayonH, getCentreY() - rayonV, getWidth(), getHeight());
		return this;
	}
}
