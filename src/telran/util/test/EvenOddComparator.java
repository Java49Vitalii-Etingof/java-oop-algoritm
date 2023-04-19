package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		boolean even1 = (int)num1 %2 == 0;
		boolean even2 = (int)num2 %2 == 0;
		int res = 0;
		if(even1 == even2) {
			res =  (even1) ? num1.compareTo(num2): num2.compareTo(num1);
		} else {
			res = (even1) ? -1: 1 ;
		}
		return res ;
	}

}
