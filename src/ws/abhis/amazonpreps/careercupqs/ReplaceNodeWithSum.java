/*
 * For a given binary search tree, replace each node with sum of all node which are greater then or equal to current node.
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.List;

import ws.abhis.amazonpreps.datastructures.BinarySearchTree;
import ws.abhis.amazonpreps.datastructures.BinarySearchTree.Node;
import ws.abhis.amazonpreps.datastructures.BinarySearchTree.Stack;

public class ReplaceNodeWithSum {
	
	public class Stack {
		private List<Integer> stack = new ArrayList<Integer>();

		public void push(Integer value) {
			stack.add(value);
		}

		public Integer pop() {
			Integer value = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			return value;
		}
		
		public int getStackCount() {
			return stack.size();
		}
	}
	
	public Stack processInOrder(List<Integer> inOrderResults) {
		int tempResult = 0;
		Stack objStack = new Stack();
		for (int i=inOrderResults.size()-1; i>=0; i--) {
			if (i == (inOrderResults.size()-1)) {
				int v = inOrderResults.get(i);
				tempResult += inOrderResults.get(i);
				objStack.push(v);
			}
			objStack.push(tempResult);
			int v = inOrderResults.get(i);
			tempResult += v;
			objStack.push(tempResult);
		}
		return objStack;
	}

	public static void main(String[] args) {
		BinarySearchTree objBinarySearchTree = new BinarySearchTree();
		objBinarySearchTree.add(20);
		objBinarySearchTree.add(10);
		objBinarySearchTree.add(40);
		objBinarySearchTree.add(60);
		objBinarySearchTree.add(100);
		objBinarySearchTree.inOrder();
		List<Integer> inOrderResult = objBinarySearchTree.getInOrder();
		ReplaceNodeWithSum obj = new ReplaceNodeWithSum();
		Stack s = obj.processInOrder(inOrderResult);
		for (int i=0; i<s.getStackCount(); i++) {
			System.out.println(s.pop());
		}
	}
	
}
