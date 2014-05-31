/*
 * Convert a BST to a doubly linked list. Tree will be destroyed. No extra spaces can be used.
 */

package ws.abhis.amazonpreps.algorithms.trees;

public class ConvertBSTToDoublyLinkedList {
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

	// Rep of LinkedList
	public class LL {
		public Node value;
		public LL prev;
		public LL next;

		public LL(Node value, LL prev, LL next) {
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}

	/*
	 * Solution 1: using in-order traversal
	 */
	private LL list = null;

	public LL solution1(Node node) {

		if (node.left != null) {
			solution1(node.left);
		}
		// Add nodes to linkedlist
		if (list == null) {
			// create the first node
			list = new LL(node, null, null);

		} else {
			LL temp = new LL(node, list, null);
			list.next = temp;
			list = temp;
		}

		if (node.right != null) {
			solution1(node.right);
		}

		return list;

	}

	/*
	 * End of solution 1
	 */

	/*
	 * Solution 2: Using pre-order
	 */

	public LL solution2(Node node) {

		// Add nodes to linkedlist
		if (list == null) {
			// create the first node
			list = new LL(node, null, null);

		} else {
			LL temp = new LL(node, list, null);
			list.next = temp;
			list = temp;
		}

		if (node.left != null) {
			solution2(node.left);
		}

		if (node.right != null) {
			solution2(node.right);
		}

		return list;

	}

	/*
	 * End of solution 2
	 */

	public void init() {
		Node one = new Node(1, new Node(2, new Node(4, null, null), new Node(5,
				null, null)), new Node(3, null, new Node(8, new Node(6, null,
				null), new Node(7, null, null))));
		LL list = null;
		list = solution1(one);

		while (list.prev != null) {
			System.out.println(list.value.value);
			list = list.prev;
		}
		System.out.println("=============================");
		// solution 2
		list = null;
		list = solution2(one);
		while (list.prev != null) {
			System.out.println(list.value.value);
			list = list.prev;
		}
	}

	public static void main(String[] args) {
		ConvertBSTToDoublyLinkedList obj = new ConvertBSTToDoublyLinkedList();
		obj.init();
	}
}
