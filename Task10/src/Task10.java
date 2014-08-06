
public class Task10 {
	public static void main(String[] args){
		//**********TASK1 (from prev lesson) Queue sorting
		System.out.println("__________TASK1 (from prev lesson) Queue sorting__________");
		MyQueue<Integer> q = new MyQueue<>();
		for(int i = 0; i < 20; i++){
			q.enqueue((int)(Math.random()*21));
		}
		System.out.println(q);
		Methods.queueSort(q);
		System.out.println(q);
	}
}
