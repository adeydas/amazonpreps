package ws.abhis.amazonpreps.careercupqs;

import ws.abhis.amazonpreps.algorithms.MergeSort;

public class FindNumberOfInversionInAnArray {
	//Use merge sort algorithm to find inversions
	private int[] numbers;
	private int[] tempArray;
	private int numbersLength;
	
	public void sort(int[] values) {
		this.numbers = values;
		this.numbersLength = values.length;
		this.tempArray = new int[numbersLength];
		mergesort(0, numbersLength-1);
	}
	
	private void mergesort(int low, int high) {
		if (low < high) {
			int middle = low + (high-low) /2;
			mergesort(low, middle);
			mergesort(middle+1, high);
			merge(low, middle, high);
		}
	}
	
	public int numberOfInversions = 0;

	private void merge (int low, int middle, int high) {
		for (int i=low; i<=high; i++) {
			tempArray[i] = numbers[i];
		}
		
		int i=low;
		int j=middle + 1;
		int k = low;
		
		while (i<=middle && j<=high) {
			if (tempArray[i] > tempArray[j]) {
				numberOfInversions++;
				j++;
			} else {
				i++;
			}
			k++;
		}
		while (i <= )
	}
	
	public static void main(String[] args) {
		FindNumberOfInversionInAnArray obj = new FindNumberOfInversionInAnArray();
		int[] values = { 2, 5, 3, 1,10 };
		obj.sort(values);
		System.out.println(obj.numberOfInversions);
	}
}
