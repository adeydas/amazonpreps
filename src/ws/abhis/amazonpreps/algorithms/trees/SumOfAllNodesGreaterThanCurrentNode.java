package ws.abhis.amazonpreps.algorithms.trees;

import ws.abhis.amazonpreps.algorithms.trees.FindPairWithGivenSumInBST.Node;

public class SumOfAllNodesGreaterThanCurrentNode {
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

	int sum = 0;

	public void findSum(Node node) {
		if (node.left != null && node.left.value < node.value) {
			// This is the first case
			if (node.right != null) {
				findSum(node.right);
			}
		} else {
			// All subsequent cases
			if (node.left != null) {
				findSum(node.left);
			}
			if (node.right != null) {
				findSum(node.right);
			}
		}
		sum += node.value;
	}

	public void init() {
		Node one = new Node(15, new Node(10, new Node(8, null, null), new Node(
				12, null, null)), new Node(20, new Node(16, null, null),
				new Node(25, null, null)));
		findSum(one);
		System.out.println(sum);
	}

	public static void main(String[] args) {
		SumOfAllNodesGreaterThanCurrentNode obj = new SumOfAllNodesGreaterThanCurrentNode();
		obj.init();
	}
}
