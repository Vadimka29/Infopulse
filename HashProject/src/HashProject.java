import java.util.*;

public class HashProject {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("Italy", 4);
		hm.put("Brazil", 1);
		//можем поменять значение
		hm.put("Brazil", 5);
		
		//SPoint
		HashMap<SPoint, String> hm2 = new HashMap<SPoint, String>();
		hm2.put(new SPoint(1, 1), "a");
		hm2.put(new SPoint(1, 2), "b");
		hm2.put(new SPoint(1, 1), "a2");
		hm2.put(new SPoint(2,1), "b2");
		//System.out.println(hm2);
		
		//hash collission
		final int N = 101;	//длинна массива
		ArrayList<Integer> ar = new  ArrayList<Integer>();
		int col = 0;	//колизии
		for(int i = 0; i <= 500; i+= 5){
			int r = i % N;
			if(ar.contains(r))
				col ++;
			ar.add(r);
		}
		//System.out.println(col);
		HashTable<String, Integer> cc = new HashTable<String, Integer>();
		cc.put("Ukraine", 604);
		cc.put("Italy", 301);
		cc.put("Ukraine", 400);
//		System.out.println(cc.remove("Ukraine"));
//		System.out.println(cc.remove("Poland"));
//		System.out.println(cc);
		
		//частотный анализ фразы
		HashTable<String, Integer> table = new HashTable<String, Integer>();
		String text = "to be or not to be";
		String[] array = text.split(" ");
		for(int i = 0; i < array.length; i++){
			int old_Size = table.size();
			table.put(array[i], 1);
			if(old_Size == table.size)
				table.put(array[i], table.get(array[i]) + 1);
		}
		System.out.println(table);
	}

}
