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
Nom du fichier: TriFormeTypeInverse.java
Date créé: 2016-06-03
Date dern. modif. 2016-06-03
 *******************************************************
Historique des modifications
 *******************************************************
2016-06-03 Version initiale
 *******************************************************/
package trialgorithm;

import java.util.Arrays;
import java.util.List;
import structurededonne.CustomLinkedList;
import forme.AbstractForme;

public class TriFormeTypeInverse implements TriStrategy {

	private List<String> formeOrder = Arrays.asList("CARRE", "RECTANGLE", "CERCLE", "OVALE", "LIGNE");
	
	public CustomLinkedList tri(CustomLinkedList arr) {
		for(int i=0;i<arr.size()-1;i++){
			for(int j=0;j<arr.size()-1;j++){
				AbstractForme current = (AbstractForme)arr.get(j);
				AbstractForme currentNext = (AbstractForme)arr.get(j+1);
				
				String currentType = current.getType();
				String currentNextType = currentNext.getType();
				
				if(formeOrder.indexOf(currentType) < formeOrder.indexOf(currentNextType)){
					arr.swapWithNext(j);
				}
			}
		}
		
		return arr;
	}
}
