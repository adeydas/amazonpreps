/*
 * Find max width of a binary tree.
 */

package ws.abhis.amazonpreps.algorithms.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class MaxWidthOfABinaryTree {
	public class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node (int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	//Calculate height of the tree
	private int height(Node node) {
		if (node == null) {
			return 0;
		} else {
			int lHeight = height(node.left);
			int rHeight = height(node.right);
			if (lHeight > rHeight ) {
				return lHeight + 1;
			} else {
				return rHeight + 1;
			}
		}
	}
	
	/*
	 * Solution 1: get maxWidth by getting width of each level by level order traversal.
	 * Time complexity: O(n^2).
	 */
	
	public int getWidth(Node node, int level) {
		//Check base cases
		if (node == null) {
			return 0;
		}
		if (level == 1) {
			return 1;
		} 
		
		if (level > 1) {
			//return the sum of the number of nodes on the left and right sub-trees
			return getWidth(node.left, level-1) + getWidth(node.right, level-1);
		}
		
		return 0;
	}
	
	public int getMaxWidth(Node node) {
		//Find the height of the tree
		int height = height(node);
		int maxWidth = Integer.MIN_VALUE;
		
		//Get width of each level and compare with the maximum width
		for (int i=1; i<=height; i++) {
			//number of levels = height of the tree
			int width = getWidth(node, i);
			if (width > maxWidth) {
				maxWidth = width;
			}
		}
		return maxWidth;
	}
	
	/*
	 * End of solution 1
	 */
	
	
	/*
	 * Solution 2: Using a hashmap.
	 * Time Complexity: O(n).
	 */
	
	private Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
	
	private void solution2(Node node, int level) {
		if (node == null) {
			return;
		}
		
		if (mp.containsKey(level)) {
			int v = mp.get(level);
			mp.put(level, ++v);
		} else {
			mp.put(level, 1);
		}
		
		solution2(node.left, level++);
		solution2(node.right, level++);
	}
	
	public int getMaxWidth2(Node node) {
		solution2(node, 1);
		Integer largestVal = Integer.MIN_VALUE;
		for (Entry<Integer, Integer> i : mp.entrySet()){
		    int v = i.getValue();
		    if (v > largestVal) {
		    	largestVal = v;
		    }
		}
		return largestVal;
	}
	
	
	/*
	 * End of solution 2
	 */
	
	//Run program
	public void init() {
		Node one = new Node(1, new Node(2, new Node(4, null, null ), new Node(5, null, null ) ), new Node(3, null, new Node(8, new Node(6, null, null ), new Node(7, null, null ) ) ));
		int maxWidthSol1 = getMaxWidth(one);
		System.out.println(maxWidthSol1);
		System.out.println(getMaxWidth2(one));
	}
	
	public static void main(String[] args) {
		MaxWidthOfABinaryTree obj = new MaxWidthOfABinaryTree();
		obj.init();
	}
	
}
