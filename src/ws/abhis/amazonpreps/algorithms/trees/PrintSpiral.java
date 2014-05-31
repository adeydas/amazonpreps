/*
 * Level order traversal in spiral form.
 */

package ws.abhis.amazonpreps.algorithms.trees;

import java.util.Stack;



public class PrintSpiral {
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
	
	private Stack<Node> st = new Stack<Node>();
	
	public void solution (Node tree) {
		
	}
}
