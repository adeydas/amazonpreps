/*
 * Construct an array of size 10 such that if a[x] =y then x should be repeated y times in that array. 
 * Eg: If a[1] = 2 then 1 should be present in that array 2 times.
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.List;

public class RepeatingArray1 {
	private static final int maxRange = 10;
	public int[] populateArray(int[] inputArray) {
		int[] outputArray = new int[maxRange];
		int pos = 0;
		for (int i=0; i<inputArray.length; i++) {
			int value = inputArray[i];
			for (int j=0; j<value; j++) {
				if (pos < 10) {
					outputArray[pos] = i;
					pos++;
				} else {
					break;
				}
			}
		}
		return outputArray;
	}
	
	public static void main(String[] args) {
		RepeatingArray1 obj = new RepeatingArray1();
		int[] input = {2,3,4,5,6};
		int[] output = obj.populateArray(input);
		for (int i=0; i<output.length; i++) {
			System.out.println(output[i]);
		}
	}
}
