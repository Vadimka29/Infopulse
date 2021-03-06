
public class Task8 {
	public static void main(String[] args){
		//Task 1 QStack
		QStack<Integer> si = new QStack<>();
		si.push(1);
		si.push(2);
		si.push(3);
		System.out.println(si);
		System.out.println("top of stack: " + si.peek() + "\nsize: " + si.size() + 
				"\nwithout top: ");
		si.pop();
		System.out.println(si);
		si.clear();
		System.out.println(si);
		//Task 2 Subsets
		System.out.println("__________Subsets: __________");
		Methods.subsets(3);
		
		//Task 3 isEqual for Circle lists
		//create and fill lists
		System.out.println("__________ IsEqual for circle lists __________");
		CircleList<Integer> first = new CircleList<>();
		CircleList<Integer> second = new CircleList<>();
		for(int i = 0; i < 10; i++){
			first.addFirst(i);
			second.addFirst(i);
		}
		first.addFirst(5);
		second.addFirst(5);
		System.out.println("first circle list: "  + first);
		System.out.println("second circle list: " + second);
		System.out.println("isEqual: " + first.isEqual(second));
	}
}
