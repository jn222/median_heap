package src;

public class MedianContainer<T extends Comparable> {
	private MinHeap high;
	private MaxHeap low;

	public MedianContainer() {
		high = new MinHeap();
		low = new MaxHeap();
	}

	public int getSize() {
		return high.getSize() + low.getSize();
	}

	public T getMedian() {
		T median;
		if (low.getSize() >= high.getSize())
			median = (T) low.getMax();
		else
			median = (T) high.getMin();
		return median;
	}

	public void insert(T element) {
		if(getSize()==0){
			low.insert(element);
			return;
		}
		if (element.compareTo(low.getMax()) <= 0)
			low.insert(element);
		else
			high.insert(element);
		if (low.getSize() > high.getSize()) {
			high.insert(low.getMax());
			low.deleteMax();
		} else if (high.getSize() > low.getSize()) {
			low.insert(high.getMin());
			high.deleteMin();
		}
	}
}
