package triAlgorithm;

import StructureDeDonne.CustomLinkedList;
import forme.Forme;

public class TriAireCroissant implements TriStrategy {

	public CustomLinkedList tri(CustomLinkedList arr) {
		for(int i=0;i<arr.size()-1;i++){
			for(int j=0;j<arr.size()-1;j++){
				Forme current = (Forme)arr.get(j);
				Forme currentNext = (Forme)arr.get(j+1);
				
				if(current.getAire() > currentNext.getAire()){
					arr.swapWithNext(j);
				}
			}
		}
		
		return arr;
	}
}
