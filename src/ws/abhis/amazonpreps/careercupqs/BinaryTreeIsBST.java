/*
 * Check if binary tree is BST
 */

package ws.abhis.amazonpreps.careercupqs;



public class BinaryTreeIsBST {
	
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

		public Node(int value, Node leftChild, Node rightChild) {
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}
	
	
	public boolean solution(Node node) {
		if (node.getLeftChild() != null && node.getRightChild() != null) {
			if (node.getLeftChild().getValue() < node.getValue() && node.getRightChild().getValue() > node.getValue()) {
				solution(node.getLeftChild());
				solution(node.getRightChild());
			} else {
				return false;
			}
		} else if (node.getLeftChild() == null && node.getRightChild() != null) {
			if (node.getRightChild().getValue() > node.getValue()) {
				solution(node.getRightChild());
			} else {
				return false;
			}
		} else if (node.getLeftChild() != null && node.getRightChild() == null) {
			if (node.getLeftChild().getValue() < node.getValue()) {
				solution(node.getLeftChild());
			} else {
				return false;
			}
		}
		return true;
	}
	
	public void initialize() {
		Node one = new Node(2, new Node(1, null, null), new Node(3, null, null));
		System.out.println(solution(one));
	}
	
	public static void main(String[] args) {
		BinaryTreeIsBST obj = new BinaryTreeIsBST();
		obj.initialize();
	}
}
