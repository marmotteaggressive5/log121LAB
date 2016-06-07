package affichage;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetrePrincipale.java
Date créé: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
2016-05-24 Derni�re Modification
 *******************************************************/

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;

import StructureDeDonne.CustomLinkedList;
import communication.CommBase;
import triAlgorithm.TriStrategy;

/**
 * Cette classe represente la fenêtre principale de l'application
 * 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = -1210804336046370508L;

	private FenetreFormes fenetreFormes = new FenetreFormes();
	private MenuFenetre menu;

	/**
	 * Constructeur
	 */
	public FenetrePrincipale(CommBase comm) {

		menu = new MenuFenetre(comm,this);
		this.setTitle("Forme-idable");
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH);

		this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fenetre de
														// forme à la fenetre
														// principale
		this.pack(); // Ajuste la dimension de la fenetre principale selon
						// celle de ses composants
		this.setVisible(true); // Rend la fenetre principale visible.

		/*
		 * CODE EMPRUNTE : Les lignes suivantes sont basees sur une fonction
		 * provenant du site :
		 * http://stackoverflow.com/questions/12601004/do-something
		 * -before-window-closes-after-user-presses-x
		 */
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// ----------Code manuellement ajout�----------
				comm.disconnectFromServer();
				System.exit(0);
				// ----------Fin du code manuellement ajout�----
			}
		});

		/* FIN DU CODE EMPRUNTE */
		
	}
	
	public void orderChange(){
		TriStrategy triAlgo = this.menu.getOrdreSelected();
		this.fenetreFormes.setTriAlgo(triAlgo);
	}

	// Appele lorsque le sujet lance "firePropertyChanger"
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

		if (arg0.getPropertyName().equals("MISE-A-JOUR-FORMES")) {

			if (arg0.getNewValue() instanceof CustomLinkedList) {

				fenetreFormes.setConteneur((CustomLinkedList) arg0.getNewValue()); // ajoute
																				// le
																				// nouveau
																				// tableau
																				// a
																				// afficher
			}

		}
	}
}
