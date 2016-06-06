package triAlgorithm;

import forme.CustomLinkedList;
import forme.Forme;

public class TriSeqDecroissant implements TriStrategy {

	public CustomLinkedList tri(CustomLinkedList arr) {
		for(int i=0;i<arr.size()-1;i++){
			for(int j=0;j<arr.size()-1;j++){
				Forme current = (Forme)arr.get(j);
				Forme currentNext = (Forme)arr.get(j+1);
				
				if(current.getNSeq() < currentNext.getNSeq()){
					arr.swapWithNext(j);
				}
			}
		}
		
		return arr;
	}
}