
public class Lection9 {
	public static void main(String[] args){
		DoublyLinkedList<Integer> lst = new DoublyLinkedList<>();
		for(int i = 0; i < 10; i++){
			lst.addLast(i);
		}
		for (Integer integer : lst) {
			System.out.println(integer);
		}
	}
}
