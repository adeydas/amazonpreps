/*
 * Find least common ancestor given parent.
 */

package ws.abhis.amazonpreps.algorithms;

public class LeastCommonAncestor {
	
	private int heightCounter;
	
	public class Node {
		private int value;
		private Node parent;
		private Node leftChild;
		private Node rightChild;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getParent() {
			return parent;
		}
		public void setParent(Node parent) {
			this.parent = parent;
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
		
		//Constructor to accept values
		public Node(int value, Node parent) {
			this.value = value;
			this.parent = parent;
			this.leftChild = null; //hard-coded for this program
			this.rightChild = null;
		}
	}
	
	public Node preProcess(Node node1, Node node2) {
		int height1 = findLevel(node1);
		int height2 = findLevel(node2);
		
		if (height1 > height2) {
			for (int i=0; i<height1-height2; i++) {
				node1 = node1.getParent();
			}
		} else {
			for (int i=0; i<height2-height1; i++) {
				node2 = node2.getParent();
			}
		}
		Node ret = solution(node1, node2);
		return ret;
	}
	
	//Find the height till given node
	private int findLevel(Node node) {
		int level = 0;
		while (node.getParent() != null) {
			node = node.getParent();
			level++;
		}
		return level;
	}
	
	
	
	public Node solution(Node node1, Node node2) {
		while (node1.getParent() != node2.getParent() || node1.getParent() != null || node2.getParent() != null) {
			node1 = node1.getParent();
			node2 = node2.getParent();
		}
		
		if (node1 == node2) {
			return node1;
		} else {
			if (node1 != null) {
				return node1;
			} else {
				return node2;
			}
		}
	}
	
	public void startProgram() {
		Node one = new Node(1, null);
		Node two = new Node (2, one);
		Node three = new Node (3, one);
		Node four = new Node (4, three);
		
		Node ret = preProcess(two, four);
		System.out.println(ret.getValue());
	}
	
	public static void main(String[] args) {
		
		LeastCommonAncestor obj = new LeastCommonAncestor();
		obj.startProgram();
		
	}
}
