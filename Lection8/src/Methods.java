
public class Methods {
	public static SinglyLinkedList<Integer> getAllDivisors(int digit){
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		for(int i = 1 ; i <= digit; i++){
			if(digit % i == 0)
				list.addLast(i);
		}
		return list;
	}
	public static SinglyLinkedList<String> getStringsWithA(String[] array){
		int counter = 0;
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		for(String temp: array){
			char[] symbols = temp.toCharArray();
			for(int i = 0; i < symbols.length; i++){
				if(symbols[i] == 'a' || symbols[i] == 'A')
					counter++;
			}
			if(counter == 2){
				list.addLast(temp);
				counter = 0;
			}
			counter = 0;
		}
		return list;
	}
	public static void sort(int[] m){
		for(int i = 1; i < m.length; i++){
			int j = i;
			int c = m[i];
			while(j > 0 && m[j-1] > c){
				m[j] = m[j-1];
				j--;
			}
			m[j] = c;
		}
	}
	public static void sort(Object[] m){
		for(int i = 1; i < m.length; i++){
			int j = i;
			Object c = m[i];
			while(j > 0 && ((Comparable) m[j-1]).compareTo(c) > 0){
				m[j] = m[j-1];
				j --;
			}
			m[j] = c;
		}
	}
	
	public static void sortC(Comparable[] m){
		for(int i = 1; i < m.length; i++){
			int j = i;
			Comparable c = m[i];
			while(j > 0 && m[j-1].compareTo(c) > 0){
				m[j] = m[j-1];
				j --;
			}
			m[j] = c;
		}
	}
}