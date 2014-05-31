/*
 * Convert a sorted integer Array to balanced binary search tree. 
 */

package ws.abhis.amazonpreps.careercupqs;

public class SortedIntegerArrayToBST {
	public class Node {
		public int value;
		public Node leftChild;
		public Node rightChild;
	}

	// Method to create a new node
	public Node newNode(int value) {
		Node node = new Node();
		node.value = value;
		node.leftChild = null;
		node.rightChild = null;
		return node;
	}

	// Since the array is sorted, the middle element will be the root.
	// Recursively, this will divide the array into left and right BST
	// sub-trees.
	public Node solution(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = (start + end) / 2;
		Node root = newNode(arr[mid]);

		root.leftChild = solution(arr, start, mid - 1);
		root.rightChild = solution(arr, mid + 1, end);

		return root;
	}

	public void printInOrder(Node root) {
		if (root == null) {
			return;
		}
		printInOrder(root.leftChild);
		System.out.println(root.value);
		printInOrder(root.rightChild);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		SortedIntegerArrayToBST obj = new SortedIntegerArrayToBST();
		Node ret = obj.solution(arr, 0, 6);
		obj.printInOrder(ret);
	}
}
