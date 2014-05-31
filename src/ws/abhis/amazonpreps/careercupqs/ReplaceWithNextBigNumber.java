/*
 * Given an Array, replace each element in the Array with its Next Element(To its RHS) which is Larger than it. If no such element exists, then no need to replace. 
Ex: 
i/p: {2,12,8,6,5,1,2,10,3,2} 
o/p:{12,12,10,10,10,2,10,10,3,2}



--Keep on putting numbers in stack and start popping and replacing on greater numbers found.
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReplaceWithNextBigNumber {
	public void solution(int[] elements) {
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> resultArray = new ArrayList<Integer>();
		for (int i=0; i<elements.length; i++) {
			if (!stack.isEmpty()) {
				//check for elements in stack and compare
				while (!stack.isEmpty()) {
					int value = stack.pop(); 
					System.out.println(value);
					if (value < elements[i]) {
						stack.push(elements[i]);
					}
				}
				
				stack.push(elements[i]);
			} else {
				stack.push(elements[i]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		ReplaceWithNextBigNumber obj = new ReplaceWithNextBigNumber();
		int[] elements = {2,12,8,6,5,1,2,10,3,2};
		obj.solution(elements);
	}
}
