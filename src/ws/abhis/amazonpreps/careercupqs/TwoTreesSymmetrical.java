/*
 * Find if two binary trees are symmetrical.
 * Asked by Groupon.
 * Complexity: O(n).
 */

package ws.abhis.amazonpreps.careercupqs;

public class TwoTreesSymmetrical {
	
	
	//Node definition
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
	
	//Check symmetry of two trees
	public boolean checkSymmetry(Node tree1, Node tree2) {
		
		//If it has reached null, the tree must be symmetric
		//else it would return false at an earlier phase
		if (tree1 == null && tree2 == null) {
			return true;
		}
		
		//Actual check for symmetry
		if ((tree1.getLeftChild() != null && tree2.getLeftChild() == null)
				|| (tree1.getLeftChild() == null && tree2.getLeftChild() != null)
				|| (tree1.getRightChild() != null && tree2.getRightChild() == null)
				|| (tree1.getRightChild() == null && tree2.getRightChild() != null)) {
			return false;
		}
		
		//Recursive calls
		checkSymmetry(tree1.getLeftChild(), tree2.getLeftChild());
		checkSymmetry(tree1.getRightChild(), tree2.getRightChild());

		return true;
	}
	
	//Start from here
	public void init() {
		// Tree1
		Node one = new Node(1, new Node(2, null, null), new Node(3, null, null));
		// Tree2
		Node two = new Node(1, new Node(2, null, null), null);
		// Tree3
		Node three = new Node(1, new Node(2, null, null), new Node(3, null,
				null));

		// check
		System.out.println(checkSymmetry(one, two)); //should return false
		System.out.println(checkSymmetry(one, three)); //should return true
	}

	public static void main(String[] args) {
		TwoTreesSymmetrical obj = new TwoTreesSymmetrical();
		obj.init();
	}

}
