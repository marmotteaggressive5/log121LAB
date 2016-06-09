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
Nom du fichier: TriSeqDecroissant.java
Date créé: 2016-06-03
Date dern. modif. 2016-06-03
 *******************************************************
Historique des modifications
 *******************************************************
2016-06-03 Version initiale
 *******************************************************/
package trialgorithm;

import structurededonne.CustomLinkedList;
import forme.AbstractForme;

public class TriSeqDecroissant implements TriStrategy {

	public CustomLinkedList tri(CustomLinkedList arr) {
		for(int i=0;i<arr.size()-1;i++){
			for(int j=0;j<arr.size()-1;j++){
				AbstractForme current = (AbstractForme)arr.get(j);
				AbstractForme currentNext = (AbstractForme)arr.get(j+1);
				
				if(current.getNSeq() < currentNext.getNSeq()){
					arr.swapWithNext(j);
				}
			}
		}
		
		return arr;
	}
}
