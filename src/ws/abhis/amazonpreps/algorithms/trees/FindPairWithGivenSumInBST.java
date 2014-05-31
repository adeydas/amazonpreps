package ws.abhis.amazonpreps.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class FindPairWithGivenSumInBST {
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

	// Do an inorder to get a sorted array of all elements
	private List<Integer> inOrderList = new ArrayList<Integer>();

	public void getInOrder(Node node) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			getInOrder(node.left);
		}
		inOrderList.add(node.value);
		if (node.right != null) {
			getInOrder(node.right);
		}
	}

	private int pair1;
	private int pair2;

	public void findPair(int sum) {
		int start = 0;
		int end = inOrderList.size() - 1;
		//Start from begining and keep comparing with the end
		for (int i=start, j=end; i<end; ) {
			int a = inOrderList.get(i);
			int b = inOrderList.get(j);
			int c = a + b;
			if (c > sum) {
				j--;
			} else if (c == sum) {
				pair1 = a;
				pair2 = b;
				return;
			} else if (c < sum) {
				i++;
			}
			else {
				return;
			}
		}
	}

	public void init() {
		Node one = new Node(15, new Node(10, new Node(8, null, null), new Node(
				12, null, null)), new Node(20, new Node(16, null, null),
				new Node(25, null, null)));
		getInOrder(one);
		findPair(36);
		System.out.println(pair1);
		System.out.println(pair2);
	}
	
	public static void main(String[] args) {
		FindPairWithGivenSumInBST obj = new FindPairWithGivenSumInBST();
		obj.init();
	}
}
