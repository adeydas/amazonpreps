/*
 * Given an array with numbers from 1 to 9 and a sub-array with numbers from the array except one,
 * find the missing element in the sub-array.
 * -Asked by Amazon, Dec 2013.
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.Arrays;

public class FindMissingElementInArray {
	
	//O(n) time complexity
	public void solution1(int[] arr, int[] subarr) {
		int arrLength = arr.length;
		int subarrLength = subarr.length;
		int arrSum = (arrLength * (arrLength+1))/2;
		int subarrSum = 0;
		for (int i=0; i<subarrLength; i++) {
			subarrSum += subarr[i];
		}
		System.out.println(arrSum - subarrSum);
	}
	
	//O(n) time complexity
	public void solution2(int[] arr, int[] subarr) {
		long xor1 = 0;
		for (int i=0; i<arr.length; i++) {
			xor1 = xor1 ^ arr[i];
		}
		long xor2 = 0;
		for (int i=0; i<subarr.length; i++) {
			xor2 = xor2 ^ subarr[i];
		}
		System.out.println(xor1 ^ xor2);
	}
	
	public static void main(String[] args) {
		FindMissingElementInArray obj = new FindMissingElementInArray();
		int[] arr = {3,1,2,4,5,7,6,9,8};
		int[] subarr = {1,5,2,3,6,4,9,7};
		obj.solution1(arr, subarr);
		obj.solution2(arr, subarr);
	}
}
