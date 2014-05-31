package ws.abhis.amazonpreps.algorithms;

public class InsertionSort {
	public int[] sort(int[] elements) {
		for (int i=1; i<elements.length; i++) {
			int j=i;
			while (j>0 && elements[j-1] > elements[j]) {
				elements = swap(elements, j, j-1);
				j=j-1;
			}
		}
		return elements;
	}
	
	private int[] swap(int[] elements, int i, int j) {
		int tmp = elements[i];
		elements[i] = elements[j];
		elements[j] = tmp;
		return elements;
	}
	
	public static void main(String[] args) {
		int[] elements = {5,6,1,4};
		InsertionSort obj = new InsertionSort();
		int[] returnElements = obj.sort(elements);
		for (int i=0; i<returnElements.length; i++) {
			System.out.println(returnElements[i]);
		}
	}
}
