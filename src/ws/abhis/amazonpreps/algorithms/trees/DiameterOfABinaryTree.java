/*
 * Find the diameter of a binary tree. Diameter is defined as:
 * 
 * max of following three
   1) Diameter of left subtree
   2) Diameter of right subtree
   3) Height of left subtree + height of right subtree + 1
 */

package ws.abhis.amazonpreps.algorithms.trees;

import ws.abhis.amazonpreps.algorithms.trees.ConvertBSTToDoublyLinkedList.Node;

public class DiameterOfABinaryTree {
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

	public int findDiameter(Node node) {
		int lDiameter = 0;
		int rDiameter = 0;
		int lHeight = 0;
		int rHeight = 0;
		// Diameter of left subtree
		if (node.left != null) {
			lDiameter = findDiameter(node.left);
		}
		// Diameter of right subtree
		if (node.right != null) {
			rDiameter = findDiameter(node.right);
		}
		// Height of left subtree
		if (node.left != null) {
			lHeight = findHeight(node.left);
		}
		// Height of right subtree
		if (node.right != null) {
			rHeight = findHeight(node.right);
		}

		return max(lHeight + rHeight + 1, max(lDiameter, rDiameter));
	}

	public int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	public int findHeight(Node node) {
		
		int lHeight = 0;
		int rHeight = 0;
		
		if (node.left != null) {
			lHeight = findHeight(node.left);
		}
		if (node.right != null) {
			rHeight = findHeight(node.right);
		}

		if (lHeight > rHeight) {
			return lHeight;
		} else if (rHeight > lHeight) {
			return rHeight;
		} else {
			return lHeight;
		}
	}

	public void init() {
		Node one = new Node(1, new Node(2, new Node(4, null, null), new Node(5,
				null, null)), new Node(3, null, new Node(8, new Node(6, null,
				null), new Node(7, null, null))));
		int r = findDiameter(one);
		System.out.println(r);
	}

	public static void main(String[] args) {
		DiameterOfABinaryTree obj = new DiameterOfABinaryTree();
		obj.init();
	}
}
