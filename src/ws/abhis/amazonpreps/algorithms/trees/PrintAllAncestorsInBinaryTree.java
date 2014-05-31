/*
 * Print Ancestors of a given node in Binary Tree
Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.
 */

package ws.abhis.amazonpreps.algorithms.trees;


public class PrintAllAncestorsInBinaryTree {
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
	
	public boolean solution(Node tree, int target) {
		if (tree == null) {
			return false;
		}
		
		if (tree.value == target) {
			return true;
		}
		
		if (solution(tree.left, target) == true || solution(tree.right, target) == true) {
			System.out.println(tree.value);
		}
		
		return false;
	}
	
	public void init() {
		Node one = new Node (1, new Node(2, new Node(3, null, null), null), null);
		solution(one, 3);
	}
	
	public static void main(String[] args) {
		PrintAllAncestorsInBinaryTree obj = new PrintAllAncestorsInBinaryTree();
		obj.init();
	}
}
