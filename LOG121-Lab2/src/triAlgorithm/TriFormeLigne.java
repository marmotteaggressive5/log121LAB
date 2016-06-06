package triAlgorithm;

import java.util.Arrays;
import java.util.List;

import forme.CustomLinkedList;
import forme.Forme;

public class TriFormeLigne implements TriStrategy {

	private List<String> formeOrder = Arrays.asList("CARRE", "RECTANGLE", "CERCLE", "OVALE", "LIGNE");
	
	public CustomLinkedList tri(CustomLinkedList arr) {
		for(int i=0;i<arr.size()-1;i++){
			for(int j=0;j<arr.size()-1;j++){
				Forme current = (Forme)arr.get(j);
				Forme currentNext = (Forme)arr.get(j+1);
				
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
