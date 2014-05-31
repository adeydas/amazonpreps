/*
 * I have two arrays A and B(each containing 8 bit integers). Find the common elements between them. 
 * Find in linear time.
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonElementsTwoArrays {
	public List<Integer> findCommonElements(int[] arr1, int[] arr2) {
		Map<Integer,Integer> storage = new HashMap<Integer,Integer>();
		List<Integer> commonElements = new ArrayList<Integer>();
		//Parse 1st array and store with count 1
		for(int i=0; i<arr1.length; i++) {
			storage.put(arr1[i], 1);
		}
		//Parse 2nd array and increase count if exists
		for (int i=0; i<arr2.length; i++) {
			if (storage.containsKey(arr2[i])) {
				storage.put(arr2[i], 2);
				commonElements.add(arr2[i]);
			} else {
				storage.put(arr2[2], 1);
			}
		}
		
		return commonElements; 
	}
	
	public static void main(String[] args) {
		int[] arr1 = {5, 10, 1, 0};
		int[] arr2 = {200, 1, 55, 5};
		
		CommonElementsTwoArrays obj = new CommonElementsTwoArrays();
		List<Integer> results = obj.findCommonElements(arr1, arr2);
		for (int i=0; i< results.size(); i++) {
			System.out.println(results.get(i));
		}
	}
}
