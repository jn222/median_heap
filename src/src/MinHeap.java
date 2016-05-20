package src;

public class MinHeap<T extends Comparable> {
	private T[] elements;
	private int size;

	public MinHeap() {
		size = 0;
		elements = (T[]) new Comparable[501];
	}

	public int getSize() {
		return size;
	}

	public T getMin() {
		if (size == 0)
			return null;
		return elements[1];
	}

	public void insert(T element) {
		if (size == 500)
			return;
		elements[0] = element;
		elements[++size] = element;
		for (int hole = size; element.compareTo(elements[hole / 2]) < 0; hole = hole / 2) {
			elements[hole] = elements[hole / 2];
			elements[hole / 2] = element;
		}
	}

	public void deleteMin() {
		if (size == 0)
			return;
		int hole = 1;
		elements[hole] = elements[size];
		elements[size--] = null;
		T tmp;
		for (int child = 2; child <= size; child = hole * 2) {
			if (child != size
					&& elements[child + 1].compareTo(elements[child]) < 0)
				child++;
			if (elements[child].compareTo(elements[hole]) < 0) {
				tmp = elements[hole];
				elements[hole] = elements[child];
				elements[child] = tmp;
				hole = child;
			} else
				break;
		}
	}

}
