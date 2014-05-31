package ws.abhis.amazonpreps.algorithms;

public class MergeSort {
	private int[] numbers;
	private int[] tempArray;
	private int numbersLength;

	public int[] getSortedArray() {
		return numbers;
	}

	public void sort(int[] values) {
		this.numbers = values;
		this.numbersLength = values.length;
		this.tempArray = new int[numbersLength];
		mergesort(0, numbersLength - 1);
	}

	private void mergesort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			tempArray[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (tempArray[i] <= tempArray[j]) {
				numbers[k] = tempArray[i];
				i++;
			} else {
				numbers[k] = tempArray[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = tempArray[i];
			k++;
			i++;
		}
	}

	public static void main(String[] args) {
		MergeSort obj = new MergeSort();
		int[] values = { 5, 6, 1, 2, 10 };
		obj.sort(values);
		int[] ret = obj.getSortedArray();
		for (int i = 0; i < ret.length; i++)
			System.out.println(ret[i]);
	}

}
