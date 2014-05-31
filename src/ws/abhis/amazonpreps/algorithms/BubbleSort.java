//Complexity: O(n2)

package ws.abhis.amazonpreps.algorithms;

public class BubbleSort {

	public int[] sort(int[] numbers) {
		int tempVar;
		for (int i = 1; i <= numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i - 1] < numbers[j]) {
					tempVar = numbers[j];
					numbers[j] = numbers[i - 1];
					numbers[i - 1] = tempVar;
				}
			}
		}
		return numbers;
	}

	public static void main(String[] args) {
		BubbleSort obj = new BubbleSort();
		int[] ap = { 3, 4, 1, 2 };

		int[] elements = obj.sort(ap);
		for (int i = 0; i < elements.length; i++) {
			System.out.println(elements[i]);
		}
	}

}
