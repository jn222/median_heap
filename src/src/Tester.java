package src;

public class Tester {
	public static void main(String[] args) {
		MedianContainer min = new MedianContainer();
		for (int i = 0; i < 500; i++) {
			min.insert(i);
		}
		System.out.println(min.getSize() + "  " + min.getMedian());
		for (int i = 500; i > 0; i--) {
			min.insert(i);
		}
		System.out.println(min.getSize() + "  " + min.getMedian());

	}
}
