/*
 * You are given an array of N elements. Each element in the range Min of int to Max of Int. 
You need to find the length of longest sequence in this array such that difference of largest and smallest element of that sequence is 1. 
The sequence need not be sequential. 

For e.g. array[]={6,10,6,7,8,9,0} 
seq {6,10} = diff is 4 len 2 
seq { 10,7,8} diff is 3 len 3 
seq { 7,8,9} diff 2 len 3 
seq {6,6,7} diff is 1 len 3 

In this example the program should return 3 . 

Complexity N*longN
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.List;

import ws.abhis.amazonpreps.algorithms.MergeSort;

public class LongestSeqWithDiffOne {

	private List<Integer> permStack = new ArrayList<Integer>();
	private List<Integer> tempStack = new ArrayList<Integer>();

	public List<Integer> getStack() {
		return permStack;
	}

	public void findSequence(int[] values) {
		// sort the input array, complexity nlogn
		MergeSort obj = new MergeSort();
		obj.sort(values);
		values = obj.getSortedArray();

		int slowPointer;
		int fastPointer;

		for (int i = 0; i < values.length; i++) {
			slowPointer = i;
			for (int j = slowPointer + 1; j < values.length; j++) {
				fastPointer = j;
				int diffBwPointers = values[fastPointer] - values[slowPointer];
				if (diffBwPointers > 1) {
					break;
				} else {
					tempStack.add(values[j]);
				}
			}
			if (tempStack.size() > permStack.size()) {
				// replace permanent stack with temporary stack
				permStack.clear();
				permStack = tempStack;
				tempStack.clear();
			}

		}
	}

	public static void main(String[] args) {
		LongestSeqWithDiffOne obj = new LongestSeqWithDiffOne();
		int[] values = { 6, 10, 6, 7, 8, 9, 0 };
		obj.findSequence(values);
		List<Integer> ret = obj.getStack();
		for (int i = 0; i < ret.size(); i++) {
			System.out.println(ret.get(i));
		}
	}

}
