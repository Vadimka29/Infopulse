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
}
