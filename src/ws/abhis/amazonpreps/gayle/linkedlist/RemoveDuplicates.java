//Remove duplicates from a linked list

package ws.abhis.amazonpreps.gayle.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RemoveDuplicates {
	private List<Integer> list = new LinkedList<Integer>();
	private void populate() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(4);
	}
	
	//Using maps - O(n) time and O(n) space
	private void removeDuplicates1() {
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for (int i=0; i<list.size(); i++)  {
			if (mp.containsKey(list.get(i))) {
				list.remove(i);
			} else {
				mp.put(list.get(i), 1);
			}
		}
	}
	
	//Using list - O(n^2) time and O(n) space
	private void removeDuplicates2() {
		List<Integer> temp = new ArrayList<Integer>();
		for (int i=0; i<list.size(); i++) {
			if (temp.contains(list.get(i))) {
				list.remove(i);
			} else {
				temp.add(list.get(i));
			}
		}
	}
	
	//Using two pointers - O(n^2) time and O(1) space
	private void removeDuplicates3() {
		for (int i=0; i<list.size(); i++) {
			for (int j=0; j<list.size(); j++) {
				if ((list.get(j) == list.get(i)) && (i!=j)) {
					list.remove(i);
				}
			}
		}
	}
	
	private void printData() {
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void main(String[] args) {
		RemoveDuplicates obj = new RemoveDuplicates();
		obj.populate();
		obj.removeDuplicates1();
		obj.printData();
		obj.populate();
		obj.removeDuplicates2();
		obj.printData();
		obj.populate();
		obj.removeDuplicates3();
		obj.printData();
	}
}
