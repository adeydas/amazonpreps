/*
 *  determine if a binary tree is height-balanced.
 */

package ws.abhis.amazonpreps.algorithms.trees;


public class DetermineIfHeightBalanced {
	public class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public int solution(Node tree, int height) {
		
		
		int lValue = solution(tree.left, height++);
		int rValue = solution(tree.right, height++);
		
		int diff = abs(lValue - rValue);
		
		if ()
	}
}
