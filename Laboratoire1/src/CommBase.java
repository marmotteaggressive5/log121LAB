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

import forme.ConteneurFormes;
import forme.CreateurFormes;

/**
 * Base d'une communication via un fil d'exécution parallele.
 */
public class CommBase {

	private final int INPUT_ARRAY_SIZE = 2;
	private final int DELAI = 1000;
	private final String LOCALHOST = "localhost";
	private final String GET = "GET";
	private final String END = "END";
	private final String COMMAND_LINE = "commande> ";
	private SwingWorker threadComm = null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	private boolean isConnected = false;
	private String hostName;
	private int portName;
	private CreateurFormes createurForme = new CreateurFormes();
	private ConteneurFormes conteneurFormes = new ConteneurFormes();
	private PrintWriter currentPrinter;
	private Socket currentSocket;

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

		if (isConnected) {
			creerCommunication();
		} else {
			JOptionPane.showMessageDialog(new JFrame(),
					"Veuillez vous connecter au serveur");
		}

	}

	/**
	 * Se connecte au serveur
	 */
	public void connectToServer() {

		String input = JOptionPane.showInputDialog("Quel est le nom de l'hote"
				+ " et du port du serveur? (Ex: localhost:10000)","localhost:10000");

		if (input != null && input != "") {
			String[] inputArray = input.split(":");

			if (inputArray.length == INPUT_ARRAY_SIZE) {
				hostName = inputArray[0];

				if (hostName.equals(LOCALHOST)) {
					this.portName = Integer.parseInt(inputArray[1]);
					isConnected = true;
					start();
				} else {
					JOptionPane
							.showMessageDialog(new JFrame(),
									"Le nom de l'hote que vous avez entre est invalide");
				}

			} else {
				JOptionPane.showMessageDialog(new JFrame(),
						"Le champ que vous avez entre est invalide");
			}
		} else {
			JOptionPane.showMessageDialog(new JFrame(),
					"Le champ que vous avez entre est vide");
		}

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
			JOptionPane.showMessageDialog(new JFrame(),
					"Vous avez ete deconnecte du serveur " + hostName
							+ " sur le port " + portName);
			stop();
		}
	}

	/**
	 * Arrete la communication
	 */
	public void stop() {

		isActif = false;
		if (threadComm != null)
			threadComm.cancel(true);

	}

	/**
	 * Creer le necessaire pour la communication avec le serveur
	 */
	protected void creerCommunication() {
		// Cree un fil d'execusion parallele au fil courant,
		threadComm = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");

				if (currentSocket != null) {
					System.out.println(currentSocket.isConnected());

				} else {
					@SuppressWarnings("resource")
					Socket aSocket = new Socket(hostName, portName);
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

				while (true) {
					Thread.sleep(DELAI);

					printer.println(GET);

					serverString = reader.readLine();

					if (serverString.equals(COMMAND_LINE)) {
						serverString = reader.readLine();
					}

					System.out.println("\n" + serverString); // affiche la
					// chaine de charactere recu par le serveur

					conteneurFormes.addForme(createurForme
							.creerForme(serverString)); // ajoute la forme dans
														// le conteneur

					// La methode suivante alerte l'observateur
					if (listener != null)
						firePropertyChange("MISE-A-JOUR-FORMES", null,
								conteneurFormes);
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
							+ hostName + " ne repond pas sur le port "
							+ portName);
					disconnectFromServer();
					firePropertyChange("SERVEUR-INACTIF", null, conteneurFormes);
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
		threadComm.execute(); // Lance le fil d'execution parallèle.
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
