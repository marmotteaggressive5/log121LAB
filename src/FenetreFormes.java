/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetreFormes.java
Date crÃ©Ã©: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
2016-05-21 Dernière Version
 *******************************************************/

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import forme.ConteneurFormes;
import forme.Forme;

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

	private Forme[] formeArray = null;

	/**
	 * Constructeur
	 */
	public FenetreFormes() {
		
	}

	public void setConteneur(final ConteneurFormes aConteneurFormes) {
		this.formeArray = aConteneurFormes.getFormeArray();
		this.repaint();
	}

	/*
	 * Affiche la liste de formes
	 */
	@Override
	public void paintComponent(final Graphics graphic) {
		if (this.formeArray != null) {

			for (int i = 0; i < formeArray.length; i++) {

				if (formeArray[i] != null) {

					formeArray[i].dessinerForme(graphic);

				} else {
					break;
				}
			}
		}
	}

	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit reserver l'espace
	 * necessaire a  son affichage
	 */
	@Override
	public Dimension getPreferredSize() {
		return dimension;
	}
}
