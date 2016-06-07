package affichage;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetreFormes.java
Date créé: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
2016-05-21 Derni�re Version
 *******************************************************/

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import structurededonne.CustomLinkedList;
import trialgorithm.*;
import forme.AbstractForme;

/**
 * Cette fenetre gere l'affichage des formes
 * 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent {

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500, 500);
	
	private TriStrategy triAlgo = null;
	private CustomLinkedList formeArrayList ;

	/**
	 * Constructeur
	 */
	public FenetreFormes() {

	}

	public void setConteneur(final CustomLinkedList CustomLinkedList) {
		this.formeArrayList = CustomLinkedList;
		triAlgo.tri(this.formeArrayList);
		this.repaint();
	}
	
	public void setTriAlgo(TriStrategy trialgo){
		this.triAlgo = trialgo;
		
		if(this.formeArrayList != null){
			triAlgo.tri(this.formeArrayList);
			this.repaint();
		}
	}

	/*
	 * Affiche la liste de formes
	 */
	@Override
	public void paintComponent(final Graphics graphic) {
		Graphics2D graph2D = (Graphics2D) graphic;
		
		if (this.formeArrayList != null) {
			
			for (int i = 0; i < formeArrayList.size(); i++) {

				if (formeArrayList.get(i) != null) {
					if(triAlgo.getClass().getName() == "triAlgorithm.OrdreOriginal"){ //Methode broche a foin
						((AbstractForme)formeArrayList.get(i)).dessinerFormeOriginal(graph2D).dessinerContourOriginal(graph2D,i);
					}else{
						((AbstractForme)formeArrayList.get(i)).dessinerForme(graph2D,i).dessinerContour(graph2D,i);
					}
				} else {
					break;
				}
			}
		}
	}

	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit reserver l'espace
	 * necessaire a� son affichage
	 */
	@Override
	public Dimension getPreferredSize() {
		return dimension;
	}
}
