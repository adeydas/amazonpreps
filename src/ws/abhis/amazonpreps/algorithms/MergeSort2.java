package ws.abhis.amazonpreps.algorithms;

public class MergeSort2 {

	private int[] array;
	private int[] tempMergArr;
	private int length;
	public static int inversionCount = 0;

	public static void main(String a[]) {

		int[] inputArr = { 2, 4, 1, 3, 5  };
		MergeSort2 mms = new MergeSort2();
		mms.sort(inputArr);
		for (int i : inputArr) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println("Inversion count " + MergeSort2.inversionCount);
	}

	public void sort(int inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		//doMergeSort(0, length - 1);
		doInversionCount(0, length - 1);
	}

	private void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
			
		}
	}
	
	private int doInversionCount(int lowerIndex, int higherIndex) {
		int invCount = 0;
		if (lowerIndex < higherIndex) {
			
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			invCount += doInversionCount(lowerIndex, middle);
			// Below step sorts the right side of the array
			invCount += doInversionCount(middle + 1, higherIndex);
			
			// Find inversions
			invCount += findInversions(lowerIndex, middle, higherIndex);
			
		}
		return invCount;
	}

	private int findInversions(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}

		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		
		int invCount = 0;
		
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				System.out.println(tempMergArr[j]);
				invCount = invCount + (middle - i);
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}
		
		return invCount;
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}

	}
}
