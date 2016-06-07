package trialgorithm;

import structurededonne.CustomLinkedList;
import forme.AbstractForme;

public class TriDistCroissant implements TriStrategy {

	public CustomLinkedList tri(CustomLinkedList arr) {
		for(int i=0;i<arr.size()-1;i++){
			for(int j=0;j<arr.size()-1;j++){
				AbstractForme current = (AbstractForme)arr.get(j);
				AbstractForme currentNext = (AbstractForme)arr.get(j+1);
				
				if(current.getDistanceMax() > currentNext.getDistanceMax()){
					arr.swapWithNext(j);
				}
			}
		}
		
		return arr;
	}
}