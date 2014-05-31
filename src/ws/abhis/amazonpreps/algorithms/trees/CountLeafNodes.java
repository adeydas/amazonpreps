/*
 * Program to count leaf nodes in a binary tree.
 */

package ws.abhis.amazonpreps.algorithms.trees;

public class CountLeafNodes {
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

	private int globalCounter = 0;

	public void solution(Node tree) {
		if (tree.left == null && tree.right == null) {
			globalCounter++;

		}
		if (tree.left != null) {
			solution(tree.left);
		}
		if (tree.right != null) {
			solution(tree.right);
		}
	}

	public void init() {
		Node one = new Node(1, new Node(2, new Node(3, new Node(4, null, null),
				null), null), null);
		solution(one);
		System.out.println("Tot" + globalCounter);
	}

	public static void main(String[] args) {
		System.out.println("HELLO");
		CountLeafNodes obj = new CountLeafNodes();
		obj.init();
	}
}
