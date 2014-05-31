package ws.abhis.amazonpreps.algorithms;

public class QuickSort {

	private int[] numbers;
	private int number;
	
	public int[] getNumbers() {
		return numbers;
	}

	public void sort(int[] values) {
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = values.length;
		quickSort(0, number - 1);
	}

	public void quickSort(int start, int end) {
		int i = start, j = end;
		// find pivot, middle element
		int pivot = numbers[start + (end - start) / 2];
		
		
		//iterate till we are left with values which need
		//to be exchanged
		while (i <= j) {
			while (numbers[i] < pivot) {
				i++;
			}
			while (numbers[j] > pivot) {
				j--;
			}
			
			//exchange is value is larger than the pivot in
			//the left list and
			//smaller than the pivot in the right list
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}

		if (start < end) {
			quickSort(start, j);
		}
		if (i < end) {
			quickSort(i, end);
		}

	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	public static void main(String[] args) {
		QuickSort obj = new QuickSort();
		int[]  a = {3, 4, 1, 2};
		obj.sort(a);
		int[] results = obj.getNumbers();
		for (int i=0; i<results.length; i++) {
			System.out.println(results[i]);
		}
	}
	
}
