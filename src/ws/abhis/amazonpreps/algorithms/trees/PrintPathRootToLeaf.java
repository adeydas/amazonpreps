/*
 * Print path from root to leaf, one per line.
 */

package ws.abhis.amazonpreps.algorithms.trees;

import java.util.Stack;



public class PrintPathRootToLeaf {
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
	
	private Stack<Integer> store = new Stack<Integer>();
	
	public void solution(Node tree) {
		if (tree == null && store.isEmpty()) {
			//nothing in tree
			return;
		}
		
		if (tree == null && !store.isEmpty()) {
			//reached leaf
			while (!store.isEmpty()) {
				System.out.println(store.pop());
			}
			System.out.println("\n");
		}
		
		store.push(tree.value);
		solution(tree.left);
		solution(tree.right);
	}
	
	public void init() {
		Node one = new Node (1, new Node(2, new Node(3, null, null), null), null);
		solution(one);
	}
	
	public static void main(String[] args) {
		DepthOfATree obj = new DepthOfATree();
		obj.init();
	}
	
	
}
