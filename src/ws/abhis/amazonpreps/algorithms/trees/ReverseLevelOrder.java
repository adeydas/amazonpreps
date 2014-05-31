package ws.abhis.amazonpreps.algorithms.trees;

import ws.abhis.amazonpreps.algorithms.trees.BoundaryTraversal.Node;

public class ReverseLevelOrder {
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

	public int getHeight(Node node) {
		if (node == null) {
			return 0;
		} else {
			int lHeight = getHeight(node.left);
			int rHeight = getHeight(node.right);

			if (lHeight > rHeight) {
				return lHeight + 1;
			} else {
				return rHeight + 1;
			}
		}
	}

	public void printLevel(Node node, int level) {
		if (level == 1) {
			System.out.println(node.value);
		} else if (level > 1) {
			if (node.left != null) {
				printLevel(node.left, level-1);
			}
			if (node.right != null) {
				printLevel(node.right, level-1);
			}
		}
	}
	
	public void startProcess(Node node) {
		int height = getHeight(node);
		for (int i = height; i>=1; i--) {
			printLevel(node, i);
		}
	}
	
	public void init() {
		Node one = new Node(20, new Node(8, new Node(4, null, null), new Node(
				12, new Node(10, null, null), new Node(14, null, null))),
				new Node(22, null, new Node(25, null, null)));
		startProcess(one);
	}
	
	public static void main(String[] args) {
		ReverseLevelOrder obj = new ReverseLevelOrder();
		obj.init();
	}
}
