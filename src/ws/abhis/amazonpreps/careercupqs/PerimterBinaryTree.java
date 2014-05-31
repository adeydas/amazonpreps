package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ws.abhis.amazonpreps.careercupqs.DiameterBinaryTree.Node;

public class PerimterBinaryTree {
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

	private List<Node> allNodes = new ArrayList<Node>();
	private static final Node separator = null;

	// Run a simple BFS with separator for each level
	// Pre-processing step
	public void solution(Node node) {
		
		if (node == null)
			System.out.println("Empty tree");
		else {
			Queue<Node> q = new LinkedList<Node>();
			Queue<Node> tempQ = new LinkedList<Node>();
			Queue<Node> resultQ = new LinkedList<Node>();
			List<Node> line = new ArrayList<Node>();
			int localDiameter = 0;
			int globalDiameter = 0;
			q.add(node);
			//Print root
			System.out.println("Root" + node.getValue());
			while (q.peek() != null) {
				
				
				
				Node temp = q.remove();
				System.out.println(temp.getValue());
				if (temp.getLeftChild() != null) {
					tempQ.add(temp.getLeftChild());
					line.add(temp.getLeftChild());
					localDiameter++;
				}
				if (temp.getRightChild() != null) {
					tempQ.add(temp.getRightChild());
					line.add(temp.getRightChild());
					localDiameter++;
				}
				
				if (q.peek() == null && tempQ.peek() != null) {
					System.out.println("Line 1" + line.get(0).getValue());
					System.out.println("Line 2" + line.get(line.size()-1).getValue());
					line = new ArrayList<Node>();
					if (localDiameter > globalDiameter) {
						globalDiameter = localDiameter;
						resultQ = tempQ;
						q = tempQ;
						
					}
				} else if (q.peek() == null && tempQ.peek() == null) {
					q = tempQ;
				}
				
			}
			
			System.out.println("Global Diameter: " + globalDiameter);
			System.out.println("Global Diameter array: ");
			while (resultQ.peek() != null) {
				System.out.println(resultQ.poll().getValue());
			}
		}
	}

	public void initiate() {
		Node one = new Node(1, new Node(2, null, null), new Node(3, null, null));
		solution(one);
	}

	public static void main(String[] args) {
		PerimterBinaryTree obj = new PerimterBinaryTree();
		obj.initiate();
	}
}
