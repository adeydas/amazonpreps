//http://www.quickperm.org/quickperm.php
package ws.abhis.amazonpreps.careercupqs;

public class QuickPermutationAlgo {
	private static void printAuxArr(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " \n");
		}
	}
	public static void findPermutations(String string) {
		// One permutation of the string is the string itself
		System.out.println(string);
		char[] arr = string.toCharArray();
		int length = arr.length;
		int[] indexArr = new int[length]; //aux arr 
		for (int i = 1; i < length;) {
			printAuxArr(indexArr);
			if (indexArr[i] < i) {
				int swapLoc;
				if (i % 2 == 0) {
					swapLoc = 0;
				} else {
					swapLoc = indexArr[i];
				}
				swap(arr, i, swapLoc);
				System.out.println(join(arr));
				indexArr[i]++;
				i = 1;
			} else {
				indexArr[i] = 0;
				i++;
			}
		}
	}
	
	private static String join(char[] a) {
		StringBuilder builder = new StringBuilder();
		builder.append(a);
		return builder.toString();
	}
	
	private static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		findPermutations("lamp");
	}
}
