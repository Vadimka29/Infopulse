import java.util.Comparator;

/**
 * Comparator for int[].
 * @author vadim
 *
 */
public class ArrayCmp implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		String firstHexNumber = o1.toString().substring(3,o1.toString().length());
		String secondHexNumber = o2.toString().substring(3,o2.toString().length());
		long firstDecimal = Long.parseLong(firstHexNumber,16);
		long secondDecimal = Long.parseLong(secondHexNumber,16);
		if(firstDecimal < secondDecimal)
			return -1;
		else if(firstDecimal > secondDecimal)
			return 1;
		else
			return 0;
	}
}
