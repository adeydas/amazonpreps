package ws.abhis.amazonpreps.algorithms.trees;

import java.util.Stack;

public class BoundaryTraversal {
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

	public void printLeft(Node node) {
		//Do not print leaves
		if (!(node.left == null && node.right == null)) {
			System.out.println(node.value);
		}
		if (node.left != null) {
			printLeft(node.left);
		}
	}

	public void printLeaf(Node node) {
		if (node.left == null && node.right == null) {
			System.out.println(node.value);
		}
		if (node.left != null) {
			printLeaf(node.left);
		}
		if (node.right != null) {
			printLeaf(node.right);
		}
	}

	Stack stack = new Stack();

	public void printRight(Node node) {
		//Do not print leaves
		if (!(node.left == null && node.right == null)) {
			stack.push(node.value);
		}
		if (node.right != null) {
			printRight(node.right);

		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public void init() {
		Node one = new Node(20, new Node(8, new Node(4, null, null), new Node(
				12, new Node(10, null, null), new Node(14, null, null))),
				new Node(22, null, new Node(25, null, null)));

		printLeft(one);
		printLeaf(one);
		//To avoid printing the root twice, one.right is sent
		printRight(one.right);
	}

	public static void main(String[] args) {
		BoundaryTraversal obj = new BoundaryTraversal();
		obj.init();
	}
}
