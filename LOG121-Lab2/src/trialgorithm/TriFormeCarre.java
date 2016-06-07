package trialgorithm;

import java.util.Arrays;
import java.util.List;
import structurededonne.CustomLinkedList;
import forme.AbstractForme;

public class TriFormeCarre implements TriStrategy {

	private List<String> formeOrder = Arrays.asList("CARRE", "RECTANGLE", "CERCLE", "OVALE", "LIGNE");
	
	public CustomLinkedList tri(CustomLinkedList arr) {
		for(int i=0;i<arr.size()-1;i++){
			for(int j=0;j<arr.size()-1;j++){
				AbstractForme current = (AbstractForme)arr.get(j);
				AbstractForme currentNext = (AbstractForme)arr.get(j+1);
				
				String currentType = current.getType();
				String currentNextType = currentNext.getType();
				
				if(formeOrder.indexOf(currentType) > formeOrder.indexOf(currentNextType)){
					arr.swapWithNext(j);
				}
			}
		}
		
		return arr;
	}
}
