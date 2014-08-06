
public class Lection9 {
	public static void main(String[] args){
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		System.out.println(dll);
		for(int i = 0; i < 10; i++){
			dll.addLast(i);
		}
		dll.addAfter(dll.first(), 10);
		System.out.println(dll);
	}
}
