/******************************************************
Cours:   LOG121
Session: E2016
Groupe:  02
Projet: Laboratoire #2
Étudiant(e)s: Philippe Torres-Brisebois
			  Nelson Chao
			  Samuel Crotteau
			  Laurent Theroux-Bombardier
Professeur : Françis Cardinal
Nom du fichier: CustomLinkedList.java
Date créé: 2016-06-03
Date dern. modif. 2016-06-07
 *******************************************************
Historique des modifications
 *******************************************************
2016-06-03 Version initiale
2016-06-07 Derniere Modification
 *******************************************************/
package structurededonne;

public class CustomLinkedList {
	private Node first;
	private Node last;
	private int nbElement;

	public CustomLinkedList() {
	}

	public int size() {
		return nbElement;
	}

	public void addAll(final CustomLinkedList customLinkedList) {

		for (int i = 0; i < customLinkedList.size(); i++) {
			this.add(customLinkedList.get(i));
		}
	}

	public void add(Object ele) {
		Node newNode = new Node(ele);
		if (nbElement == 0) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = last.next;
		}
		nbElement++;
	}

	public Object get(int index) {
		Node result = first;
		for (int i = 0; i <= index - 1; i++) {
			result = result.next;
		}

		return result.element;
	}

	private Node getNode(int index) {
		Node result = first;
		for (int i = 0; i <= index - 1; i++) {
			result = result.next;
		}

		return result;
	}

	public String toString() {
		String result = "";
		Node current = first;
		while (current.next != null) {
			result += current.element + " - ";
			current = current.next;
		}
		return result;
	}

	public void swapWithNext(int index) {
		Object temp = get(index);
		getNode(index).element = get(index + 1);
		getNode(index + 1).element = temp;
	}

	public void clear() {
		first = null;
		last = null;
		nbElement = 0;
	}

	private class Node {
		private Node next = null;
		private Object element = null;

		public Node(Object element) {
			this.element = element;
		}
	}
}
