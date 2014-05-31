/*
 * write a O(n) based code to find the major element in an array. 
array is 6,7,7,8,8,2,3,8,8,11,23,8,8,,3,3,4,4,4 

output should be 8 because it is repeated max no. of times in the array. 
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MajorElementInArray {
	
	//one solution using hashmaps
	public void solution1(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<arr.length; i++) {
			int v = arr[i];
			if (map.containsKey(v)) {
				int f = map.get(v);
				map.put(v, f++);
			} else {
				map.put(v, 1);
			}
		}
		
		Iterator it = map.entrySet().iterator();
		int globalMax = 0;
		int globalValue = 0;
		while (it.hasNext()) {
			Entry e = (Entry) it.next();
			if ((int)e.getValue() > globalMax) {
				globalMax = (int)e.getValue();
				globalValue = (int) e.getKey();
				System.out.println(globalValue);
			}
		}
		System.out.println(globalValue);
	}
	
	public static void main(String[] args) {
		MajorElementInArray obj = new MajorElementInArray();
		int[] arr = {6,7,7,8,8,2,3,8,8,11,23,8,8,3,3,4,4,4};
		obj.solution1(arr);
	}
}
