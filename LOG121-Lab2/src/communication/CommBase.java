package communication;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: CommBase.java
Date créé: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
2016-05-24 Derni�re Modification
 *******************************************************/

import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import forme.CreateurFormes;
import forme.CustomLinkedList;

/**
 * Base d'une communication via un fil d'exécution parallele.
 */
public class CommBase {

	private final int DELAI = 100;
	private final String GET = "GET";
	private final String END = "END";
	private final String COMMAND_LINE = "commande> ";
	private final String HOSTNAME = "localhost";
	private final int PORTNAME = 10000;
	@SuppressWarnings("rawtypes")
	private SwingWorker threadComm = null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	private boolean isConnected = false;
	private PrintWriter currentPrinter;
	private CreateurFormes createurForme = new CreateurFormes();
	private CustomLinkedList formeArray = new CustomLinkedList();
	private Socket currentSocket;
	private final int NUMBER_OF_FORME = 10;

	/**
	 * Constructeur
	 */
	public CommBase() {

	}

	/**
	 * Definir le recepteur de l'information recue dans la communication avec le
	 * serveur
	 * 
	 * @param listener
	 *            sera alerte lors de l'appel de "firePropertyChanger" par le
	 *            SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener) {
		this.listener = listener;
	}

	/**
	 * Demarre la communication
	 */
	public void start() {
		isConnected = true;
		creerCommunication();
	}

	/**
	 * Arrete la communication
	 */
	public void stop() {
		if (threadComm != null)
			threadComm.cancel(true);
	}
	
	/**
	 * Se deconnecte du serveur
	 */
	public void disconnectFromServer() {
		if (isConnected) {
			if (currentPrinter != null) {
				currentPrinter.println(END);
			}
			isConnected = false;
			isActif = false;
			currentSocket = null;
//			JOptionPane.showMessageDialog(new JFrame(),
//					"Vous avez ete deconnecte du serveur " + HOSTNAME
//							+ " sur le port " + PORTNAME);
			stop();
		}
	}
	

	/**
	 * Creer le necessaire pour la communication avec le serveur
	 */
	@SuppressWarnings("rawtypes")
	protected void creerCommunication() {
		// Cree un fil d'execusion parallele au fil courant,
		threadComm = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {
				if (currentSocket == null) {
					Socket aSocket = new Socket(HOSTNAME, PORTNAME);
					currentSocket = aSocket;
				}

				/*
				 * CODE EMPRUNTE : Les lignes suivantes sont basees sur une
				 * fonction provenant du site :
				 * https://docs.oracle.com/javase/tutorial
				 * /networking/sockets/readingWriting.html Ces lignes permettent
				 * de lire et d'ecrire a partir des donnees sur le socket.
				 */

				PrintWriter printer = new PrintWriter(
						currentSocket.getOutputStream(), true);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(currentSocket.getInputStream()));

				/* FIN DU CODE EMPRUNTE */

				currentPrinter = printer;
				
				String serverString;

				formeArray.clear();
				
				while (true) {
					Thread.sleep(DELAI);
					
					for (int i = 0; i < NUMBER_OF_FORME; i++) {
						printer.println(GET);

						serverString = reader.readLine();

						if (serverString.equals(COMMAND_LINE)) {
							serverString = reader.readLine();
						}

						System.out.println("\nForme " + (i + 1) + ":\t" + serverString); // affiche la
						// chaine de charactere recu par le serveur

						formeArray.add(createurForme
								.creerForme(serverString)); // ajoute la forme dans
															// le conteneur
					}
					
					
					disconnectFromServer();
					

					// La methode suivante alerte l'observateur
					if (listener != null)
						firePropertyChange("MISE-A-JOUR-FORMES", null,
								formeArray);
				}
			}

			/*
			 * CODE EMPRUNTE : Les lignes suivantes sont basees sur une fonction
			 * provenant du site : 
			 * /stackoverflow.com/questions/11255925/use-of-swingworker-to-
			 * do-complex-tasks-in-background
			 */

			@Override
			protected void done() {
				// -----------------Code ajoute
				// manuellement--------------------------
				if (isActif) {
					JOptionPane.showMessageDialog(new JFrame(), "Le serveur "
							+ HOSTNAME + " ne repond pas sur le port "
							+ PORTNAME);
					stop();
				}

				// -----------------Fin du code ajoute
				// manuellement--------------------------
			}
			/* FIN DU CODE EMPRUNTE */
		};
		if (listener != null)
			threadComm.addPropertyChangeListener(listener); // La methode
															// "propertyChange"
															// de
															// ApplicationFormes
															// sera donc
															// appelée lorsque
															// le SwinkWorker
															// invoquera la
															// methode
															// "firePropertyChanger"
		threadComm.execute(); // Lance le fil d'execution parallele.
		isActif = true;
	}

	/**
	 * @return si le fil d'execution parallele est actif
	 */
	public boolean isActif() {
		return isActif;
	}

	/**
	 * @return si l'application est connectee au serveur
	 */
	public boolean isConnected() {
		return isConnected;
	}
}
