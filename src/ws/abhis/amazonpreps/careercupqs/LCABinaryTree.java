/*
 * Given two nodes, compute the LCA (Least common ancestor) in a binary tree.
 */

package ws.abhis.amazonpreps.careercupqs;

public class LCABinaryTree {
	public class Node {
		private int value;
		private Node leftChild;
		private Node rightChild;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(Node leftChild) {
			this.leftChild = leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}

		public void setRightChild(Node rightChild) {
			this.rightChild = rightChild;
		}
	}

	public Node solution(Node node1, Node node2, Node root) {
		// Base case, check whether a tree exists
		if (root == null) {
			return null;
		}
		// Base case, if root is one of the two nodes
		if (root == node1 || root == node2) {
			return root;
		}

		Node L = solution(node1, node2, root.getLeftChild());
		Node R = solution(node2, node2, root.getRightChild());

		// If the two nodes are on the left and right sub-trees from parent
		if (L != null && R != null) {
			return root;
		}

		// Either one node is on one branch or none was found in any of the
		// branches
		return L != null ? L : R;
	}

}
