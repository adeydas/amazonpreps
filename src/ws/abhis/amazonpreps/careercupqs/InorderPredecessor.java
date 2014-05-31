/*
 * Find In order predecessor in BST.
 */

package ws.abhis.amazonpreps.careercupqs;



public class InorderPredecessor {
	
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
	
	
	/*
	 * Case 1: Node is left most node of BST. 
	Return NULL 
	Case 2: Node has left sub tree. 
	In this case it is Maximum Node in the Left Sub-Tree. i.e., the right most node in the left sub-tree 
	would be the in-order predecessor. 
	Case 3: Node has no left sub-tree. 
	In this case in-order predecessor will be the node where we took the latest right turn. 
	 */

	
	public Node solution(Node node, Node root) {
		//Case 1
		if (node.getLeftChild() == null && node.getRightChild() == null) {
			return null;
		}
		
		//Case 2
		if (node.getLeftChild() != null) {
			return case2(node.getLeftChild());
		} else {
			//Case 3
			return case3(node, root);
		}
	}
	
	private Node case2(Node node) {
		if (node.getRightChild() == null && node.getLeftChild() == null) {
			return node;
		} else {
			case2(node.getRightChild());
		}
		return null;
	}
	
	private Node case3(Node node, Node root) {
		if (root.getRightChild() == node) {
			return root;
		} else {
			case3(node, root.getLeftChild());
			case3(node, root.getRightChild());
		}
		return null;
	}
	
}
