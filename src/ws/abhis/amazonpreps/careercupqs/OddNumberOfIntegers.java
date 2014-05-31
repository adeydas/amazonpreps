/*
 * Array of Integers with even number of same Integers. Find the Integer that is an odd number of times.
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.List;

public class OddNumberOfIntegers {
	public List<Integer> solution (int[] elements) {
		int length = elements.length;
		int lastElement = elements[0];
		List<Integer> resultArray = new ArrayList<Integer>();
		for (int i=1; i<length; i++) {
			resultArray.add(elements[i] ^ lastElement);
			lastElement = elements[i];
		}
		return resultArray;
	}
	
	public static void main(String[] args) {
		int[] elements = {1,1,2,2,3,3,4,4,5,5,5,6,6,7,7,8,8,8,8,9,9,10,10} ;
		OddNumberOfIntegers obj = new OddNumberOfIntegers();
		List<Integer> result = obj.solution(elements);
		for (int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
