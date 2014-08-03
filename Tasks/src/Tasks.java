
public class Tasks {
	
	public static void main(String[] args) {
		//TEST1
		Methods.paintCross(6);
		//TEST2
		System.out.print("Euclid Method: " + "GCD(6,12) = ");
		System.out.println(Methods.euclid(6, 12));
		System.out.println();
		
		//TEST3
		int mass[] = new int[50];
		System.out.println("\n \n ********** INSERTION SORT **********");
		System.out.println("array size: " + mass.length);
		//fill the mass with random numbers [0;100]
		System.out.println("__________Old array___________");
		for(int i = 0; i < mass.length; i ++) {
			mass[i] = (int) (Math.random()*101);
			System.out.print(mass[i]);
			System.out.print(" ");
		}
		//sorting mass
		long start = System.nanoTime();
		Methods.insertionSort(mass);
		long finish = System.nanoTime();
		
		System.out.print("\n___________Sorted array__________");
		System.out.println();
		//
		for(int i = 0; i < mass.length; i ++) {
			System.out.print(mass[i]);
			System.out.print(" ");
		}
		System.out.println("\nTime of sorting: " + (finish - start) + " nanoseconds");
		//Test4
		int array[] = new int[50];
		int max = 100;
		System.out.println("\n \n ********** BUCKET SORT **********");
		System.out.println("array size: " + array.length);
		//fill the mass with random numbers [0;100]
		System.out.println("__________Old array___________");
		for(int i = 0; i < array.length; i ++) {
			array[i] = (int) (Math.random()*101);
			System.out.print(array[i]);
			System.out.print(" ");
		}
		long start1 = System.nanoTime();
		Methods.bucketSort(array, max);
		long finish1 = System.nanoTime();
		//sorted array
		System.out.println("\n____________Sorted array__________");
		for(int i = 0; i < array.length; i ++) {
			System.out.print(array[i]);
			System.out.print(" ");
		}
		System.out.println("\nTime of sorting: " + (finish1 - start1) + " nanoseconds");
	}

}
