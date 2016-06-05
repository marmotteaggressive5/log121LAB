package affichage;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: MenuFenetre.java
Date crÃ©Ã©: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
2016-05-24 Dernière Version
 *******************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import communication.CommBase;

/**
 * Cree le menu de la fenetre de l'application
 */
public class MenuFenetre extends JMenuBar {

	private static final long serialVersionUID = 1536336192561843187L;
	private static final int MENU_FICHIER_OBTENIR_FORME_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_OBTENIR_FORME_TOUCHE_RACC = KeyEvent.VK_O;
	private static final int MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;
	private static final String MENU_ORDRE_TITRE = "app.frame.menus.order.title",
			MENU_ORDRE_NUMERO_SEQUENCE_CROISSANT = "app.frame.menus.order.sequencenumber.ascending",
			MENU_ORDRE_NUMERO_SEQUENCE_DECROISSANT = "app.frame.menus.order.sequencenumber.descending",
			
			MENU_ORDRE_AIRE_CROISSANTE = "app.frame.menus.order.area.ascending",
			MENU_ORDRE_AIRE_DECROISSANTE = "app.frame.menus.order.area.descending",
			MENU_ORDRE_TYPE_REGULIER = "app.frame.menus.order.type.regular",
			MENU_ORDRE_TYPE_INVERSE = "app.frame.menus.order.type.inverted",
			MENU_ORDRE_DISTANCE_CROISSANTE = "app.frame.menus.order.distance.ascending",
			MENU_ORDRE_LARGEUR_CROISSANTE = "app.frame.menus.order.width.ascending",
			MENU_ORDRE_LARGEUR_DECROISSANTE = "app.frame.menus.order.width.descending",
			MENU_ORDRE_HAUTEUR_CROISSANTE = "app.frame.menus.order.height.ascending",
			MENU_ORDRE_HAUTEUR_DECROISSANTE = "app.frame.menus.order.height.descending",
			MENU_ORDRE_ORIGINAL = "app.frame.menus.order.original",
			
			MENU_FICHIER_TITRE = "app.frame.menus.file.title",
			MENU_FICHIER_OBTENIR_FORMES = "app.frame.menus.file.getshapes",
			MENU_FICHIER_QUITTER = "app.frame.menus.file.exit",
			MENU_AIDE_TITRE = "app.frame.menus.help.title",
			MENU_AIDE_PROPOS = "app.frame.menus.help.about";
	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about";
	
	private JMenuItem obternirFormesMenuItem, quitterMenuItem;
	private static final int DELAI_QUITTER_MSEC = 200;

	private CommBase comm; // Pour activer/dÃ©sactiver la communication avec le
							// serveur

	/**
	 * Constructeur
	 */
	public MenuFenetre(CommBase comm) {
		this.comm = comm;
		addMenuFichier();
		addMenuOrdre();
		addMenuAide();
	}


	public void addMenuOrdre() {
		
//		par numéro de séquence croissant
//		par numéro de séquence décroissant
		
//		par aire de forme croissante
//		par aire de forme décroissante
		
//		par type de forme dans l'ordre suivant 
//		par type de forme dans l'ordre inverse 
		
//		par distance (croissante) 
		
//		par largeur croissante
//		par largeur décroissante
//		par hauteur croissante
//		par hauteur décroissante
//		selon l'ordre original
		
		 JMenu menu = creerRadioMenu(MENU_ORDRE_TITRE,
					new String[] { 
				 MENU_ORDRE_NUMERO_SEQUENCE_CROISSANT,
				 MENU_ORDRE_NUMERO_SEQUENCE_DECROISSANT,
				 MENU_ORDRE_AIRE_CROISSANTE,
				 MENU_ORDRE_AIRE_DECROISSANTE,
				 MENU_ORDRE_TYPE_REGULIER,
				 MENU_ORDRE_TYPE_INVERSE,
				 MENU_ORDRE_DISTANCE_CROISSANTE,
				 MENU_ORDRE_LARGEUR_CROISSANTE,
				 MENU_ORDRE_LARGEUR_DECROISSANTE,
				 MENU_ORDRE_HAUTEUR_CROISSANTE,
				 MENU_ORDRE_HAUTEUR_DECROISSANTE,
				 MENU_ORDRE_ORIGINAL
		 });
		 		
		add(menu);
		
	}
	/**
	 * Creer le menu "File".
	 */
	protected void addMenuFichier() {
		JMenu menu = creerMenu(MENU_FICHIER_TITRE,
				new String[] { 
				MENU_FICHIER_OBTENIR_FORMES,
				MENU_FICHIER_QUITTER });
		
		
		obternirFormesMenuItem = menu.getItem(0);
		obternirFormesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.start();
			}
		});
		obternirFormesMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_FICHIER_OBTENIR_FORME_TOUCHE_RACC,
				MENU_FICHIER_OBTENIR_FORME_TOUCHE_MASK));
		
		
		quitterMenuItem = menu.getItem(1);
		
		quitterMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.disconnectFromServer();
				try {
					Thread.sleep(DELAI_QUITTER_MSEC);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		quitterMenuItem.setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_QUITTER_TOUCHE_RACC,
						MENU_FICHIER_QUITTER_TOUCHE_MASK));
		add(menu);
	}

	/**
	 * Creer le menu "Help".
	 */
	private void addMenuAide() {
		JMenu menu = creerMenu(MENU_AIDE_TITRE,
				new String[] { MENU_AIDE_PROPOS });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						LangueConfig.getResource(MESSAGE_DIALOGUE_A_PROPOS),
						LangueConfig.getResource(MENU_AIDE_PROPOS),
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}

	
	/**
	 * Creer un element de menu a  partir d'un champs principal et ses elements
	 * 
	 * @param titleKey
	 *            champs principal
	 * @param itemKeys
	 *            Ã©lÃ©ments
	 * @return le menu
	 */
	private static JMenu creerRadioMenu(String titleKey, String[] itemKeys) {
		JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
		ButtonGroup group = new ButtonGroup();
		for (int i = 0; i < itemKeys.length; ++i) {
			JRadioButtonMenuItem radioButton = new JRadioButtonMenuItem(LangueConfig.getResource(itemKeys[i]));
			group.add(radioButton);
			menu.add(radioButton);
		}
		return menu;
	}
	
	/**
	 * Creer un element de menu a  partir d'un champs principal et ses elements
	 * 
	 * @param titleKey
	 *            champs principal
	 * @param itemKeys
	 *            Ã©lÃ©ments
	 * @return le menu
	 */
	private static JMenu creerMenu(String titleKey, String[] itemKeys) {
		JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
		for (int i = 0; i < itemKeys.length; ++i) {
			menu.add(new JMenuItem(LangueConfig.getResource(itemKeys[i])));
		}
		return menu;
	}
}
