package tree;

import java.util.Comparator;

public class IntCmp implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {
		return a.intValue() - b.intValue();
	}
	
}
