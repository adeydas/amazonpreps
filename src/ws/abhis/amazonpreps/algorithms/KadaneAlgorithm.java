/*
 * For a given array with positive and negative element, find sub array with maximum sum. 
 * Sub array must have same sequence of element as that of parental array. 
Eg: P = {4,6,-3,1,5,9,-2} then S ={4,6,-3,1,5,9} //Correct output.
 */

package ws.abhis.amazonpreps.algorithms;

public class KadaneAlgorithm {
	public int findGreatestSum(int[] arr) {
		int max_so_far = 0;
		int max_ending_here = 0;
		for (int i=0; i<arr.length; i++) {
			int v = arr[i];
			max_ending_here += v;
			if (max_ending_here < 0) {
				max_ending_here = 0;
			} else if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
			}
		}
		return max_so_far;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,6,-3,1,5,9,-2};
		KadaneAlgorithm obj = new KadaneAlgorithm();
		System.out.println(obj.findGreatestSum(arr));
	}
}
