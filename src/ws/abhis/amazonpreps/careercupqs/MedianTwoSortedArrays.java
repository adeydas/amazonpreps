/*
 * Find the median of two given sorted array. Give the solution with complexity < O(n).
 * --Solution is constant time.
 */

package ws.abhis.amazonpreps.careercupqs;

public class MedianTwoSortedArrays {
	public int findMedian(int[] arr1, int[] arr2) {
		int arr1Length = arr1.length;
		int arr2Length = arr2.length;
		int totalLength = arr1Length + arr2Length;
		int totalMedianLocation = totalLength/2;
		if (arr1Length < arr2Length) {
			//median must lie in arr2
			int location = totalMedianLocation - arr1Length;
			return arr2[location];
		} else {
			//median must lie in arr1
			int location = totalMedianLocation - arr2Length;
			return arr2[location];
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,3};
		int[] arr2 = {4,5,6,7,8};
		MedianTwoSortedArrays obj = new MedianTwoSortedArrays();
		System.out.println(obj.findMedian(arr1, arr2));
	}
}
