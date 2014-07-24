import java.util.Arrays;


public class Task5 {
	public static void main(String[] args) {
		//********** TASK1 **********
		System.out.println("__________TASK 1: get digits of number__________");
		System.out.println("Number digits: " + Methods.getNumberDigits(128) + "\n");
		
		//********** TASK2 **********
		System.out.println("__________TASK 2:  MyList__________");
		//initialization of MyList
		int[] mass = {1,2,3};
		MyList lst = new MyList(mass);
		//add some values
		lst.add(10);
		lst.add(11);
		//add array at the end of MyList
		int[] temp = {1,2,3,4};
		lst.add(temp);
		//Print MyList
		System.out.println("MyList: " + Arrays.toString(lst.toArray()));
		//get element of MyList
		System.out.println("last element: " + lst.get(lst.length() - 1));
		//set last element of MyList
		lst.set(lst.length() - 1, 10);
		System.out.println("new last element: " + lst.get(lst.length() - 1));

		System.out.println("With new last value:" + Arrays.toString(lst.toArray()));
		//remove last element of MyList
		lst.remove(lst.length() - 1);
		System.out.println("after removing of last value:" + Arrays.toString(lst.toArray()));
		//write MyList to MyList.txt file
		//ATTENTION! write your own path
		//System.out.println(lst.writeToFile("/home/vadim/Документы"));
		
		//********** TASK 3: arrays and stack **********
		//ATTENTION! ENTER YOUR OWN PATH TO /src folder of current project
//		String path = "/media/vadim/0484FD0484FCF8CE/Homework/Task5/src/ArrayWriter.java";
//		Methods.arrayClassWriter(path);
		//first we make recursion with ArrayWriter object then make it without this object
//		ArrayWriter aw = new ArrayWriter();
//		Methods.recursion();
	} 

}
