/*
 * Find Kth to last element of a singly LL
 */

package ws.abhis.amazonpreps.gayle.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class KthToLastElementSinglyLL {
	
	public List<Integer> getKthToLastElement(List<Integer> list, int kVal) {
		boolean flip = false;
		List<Integer> returnList = new LinkedList<Integer>();
		for (int i=0; i<list.size(); i++) {
			if (i==kVal) {
				flip = true;
			}
			if (flip) {
				returnList.add(list.get(i));
			}
		}
		return returnList;
	}
	
	public static void main(String[] args) {
		KthToLastElementSinglyLL obj = new KthToLastElementSinglyLL();
		List<Integer> theList = new LinkedList<Integer>();
		theList.add(1); theList.add(2); theList.add(3); theList.add(4);
		List<Integer> ret = obj.getKthToLastElement(theList, 2);
		for (int i=0; i<ret.size(); i++) {
			System.out.println(ret.get(i));
		}
	}
}
