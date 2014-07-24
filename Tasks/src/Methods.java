
public class Methods {
	//cross
	//int l - width of cross
	public static void paintCross(int l) {
		int N = l*3;
		for(int i = 0; i < N; i ++){
			for(int j = 0; j < N; j++) {
				if(((i >= l)&&(i < 2*l)) || ((j >= l) && (j < 2*l)) ){
					System.out.print("*");
					System.out.print(" ");
				}
				else {
					System.out.print("-");
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	//Euclid algorithm
	//find greatest common divisor
	public static int euclid(int p, int q) {
		if(q == 0)
			return p;
		int r = p % q;
		return euclid(q, r);
	}
		//Insertion sort
	public static void insertionSort(int mass[]) {
		int swap = 0;
		int N = mass.length;
		for(int i = 1; i < N; i ++){
			for(int j = i; j > 0; j --) {
				if(mass[j] < mass[j-1]){
					int temp = mass[j];
					mass[j] = mass[j-1];
					mass[j-1] = temp;
					swap ++;
				}
			}
		}
		System.out.print("\nCount of swaps: " + swap);
	}
	//Bucket Sort
	public static void bucketSort(int mass[], int max) {
		int N = mass.length;
		//the number of each values
		int count[] = new int[max+1];
		//write 0 in all 
		for(int i = 0; i < count.length; i++)
			count[i] = 0;
		
		for(int i = 0; i < mass.length; i++)
			count[mass[i]] ++;
		
		//sorting
		int k = 0;
		for(int j = 0; j < count.length; j ++){
			while(count[j] != 0) {
				mass[k] = j;
				k++;
				count[j] --;
			}
		}
	}
}
