/*
 * Given a binary search tree (BST) with each node having some value. 
 * You have to compute for each node the summation of all nodes whose value is greater than the current node.
 */

package ws.abhis.amazonpreps.careercupqs;

public class SumOfAllNodesGreaterThanCurrentNodeBST {
	public class Node {
		private int value;
		private Node leftChild;

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

		private Node rightChild;

		public Node(int value, Node leftChild, Node rightChild) {
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}

	private int sum = 0;

	private void calculateSum(Node node) {
		if (node != null) {
			calculateSum(node.getRightChild());
			sum += node.getValue();
		}
		
	}

	public void init() {
		Node node = new Node(10, new Node(4, null, null), new Node(12, null,
				new Node(15, null, null)));
		calculateSum(node);
		System.out.println(sum);
	}

	public static void main(String[] args) {
		SumOfAllNodesGreaterThanCurrentNodeBST obj = new SumOfAllNodesGreaterThanCurrentNodeBST();
		obj.init();
	}

}
