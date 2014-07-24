
public class Ex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int k = Integer.parseInt(args[0]);
			System.out.println("#");
			System.out.println(10/k);
			System.out.println("##");
		} catch(RuntimeException ae) {
			System.out.println("From RuntimeExc. catch : " + ae);
		}
		finally { System.out.println("###");
		};
		System.out.print("####");
	}

}
