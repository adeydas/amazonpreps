/*
 * Sliding window problem where window size is 3 and we need to find the minimum from the window.
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowProblem {
	private List<Integer> values = new ArrayList<Integer>();
	
	public void insertElements(int element) {
		values.add(element);
	}
	
	public void findMin(int windowSize) {
		for (int i=0; i<values.size(); i=i+windowSize) {
			int globalMinimum = Integer.MAX_VALUE;
			for (int k=i; k<i+windowSize; k++) {
				int v = values.get(k);
				if (v < globalMinimum) {
					globalMinimum = v;
				}
			}
			System.out.println(globalMinimum);
		}
	}
	
	public static void main(String[] args) {
		SlidingWindowProblem obj = new SlidingWindowProblem();
		obj.insertElements(5);
		obj.insertElements(6);
		obj.insertElements(10);
		obj.insertElements(11);
		obj.insertElements(1);
		obj.insertElements(15);
		obj.insertElements(2);
		obj.insertElements(0);
		obj.insertElements(44);
		obj.findMin(3);
	}
}
