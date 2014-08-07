import java.io.File;

public class Methods {
	@SuppressWarnings("unchecked")
	public static <E> void queueSort(MyQueue<E> q) {
		int range = q.size();
		// find min element
		while (range > 0) {
			Comparable<E> min = (Comparable<E>) q.front();
			E cur = q.front();
			for (int i = 0; i < range; i++) {
				cur = q.dequeue();
				if (min.compareTo(cur) > 0) {
					min = (Comparable<E>) cur;
				}
				q.enqueue(cur);
			}
			//return queue to initial state
			for(int i = 0; i < q.size() - range; i++){
				q.enqueue(q.dequeue());
			}
			E minTemp = q.front();
			cur = q.front();
			int size = q.size();
			int minCount = 0;
			//extract all min values and equeue it
			for (int i = 0; i < size; i++) {
				cur = q.dequeue();
				if (min.compareTo(cur) == 0) {
					minCount ++;
					minTemp = cur;
					continue;
				}
				q.enqueue(cur);
			}
			for(int j = 0; j < minCount; j++)
				q.enqueue(minTemp);
			//change range of min finding
			range = range - minCount;
		}
	}

	public static <E extends Comparable<E>> void stackSort(QStack<E> st) {
		QStack<E> container = new QStack<>();
		QStack<E> minTemp = new QStack<>();
		int stSize = st.size();
		for (int j = 0; j < stSize; j++) {
			int N = st.size();
			Comparable<E> minElement = st.peek();
			for (int i = 0; i < N; i++) {
					E tempElement = st.pop();
					if (minElement.compareTo(tempElement) > 0) {
						minElement = tempElement;
					}
					container.push(tempElement);
			}
			int minCount = 0;
			for(int k = 0; k < N; k++){
				E e = container.pop();
				if(minElement.compareTo(e) == 0){
					minTemp.push(e);
					minCount ++;
				}
				else{
					st.push(e);
				}
			}
			j += minCount -1;
			N = st.size();
		}
		int size = minTemp.size();
		for(int i = 0; i < size; i++){
			st.push(minTemp.pop());
		}
	}
	public static DoublyLinkedList<File> getAllFiles(String url){
		File dir = new File(url);
		DoublyLinkedList<File> dll = new DoublyLinkedList<>();
		if(!dir.isDirectory())
			throw new RuntimeException("wrong parametr");
		File[] array = dir.listFiles();
		for(int i = 0; i < array.length; i++){
			dll.addLast(array[i]);
		}
		for(File file: dll){
			if(file.isDirectory()){
				File[] temp = file.listFiles();
				for(int i = 0; i < temp.length; i++){
					dll.addLast(temp[i]);
				}
			}
		}
		return dll;
	}
}
