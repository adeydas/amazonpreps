/*
 * delete all the nodes from a binary tree that lie on a path whose sum from root to leaf is less than a given value K.
 */

package ws.abhis.amazonpreps.careercupqs;

public class DeleteNodesLessThanSum {

	public class Node {
		public int value;
		public Node leftChild;
		public Node rightChild;

		public Node(int value, Node leftChild, Node rightChild) {
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		
		public Node() {}
	}
	
	private Node termNode = new Node();
	
	public boolean solution(Node root, int sum) {
		
		
		
		if (root == null) {
			if (sum <= 0) {
				return true;
			} else {
				return false;
			}
		}
		
		termNode = root;
		
		sum = sum - root.value;
		boolean lValue = solution(root.leftChild, sum);
		boolean rValue = solution(root.rightChild, sum);
		
		if (!lValue) {

			root.leftChild = null;
		}

		if (!rValue) {

			root.rightChild = null;
		}

		if (!lValue && !rValue) {
			return false;
		} else {
			return true;
		}
	}

	// 	 40
	// 	 / \
	// 10 100
	// 	   / \
	//    60 150

	public void init() {
		Node one = new Node(40, new Node(10, null, null), new Node(100,
				new Node(60, null, null), new Node(150, null, null)));
		System.out.println(solution(one, 210));
		System.out.println(termNode.value);
	}

	public static void main(String[] args) {
		DeleteNodesLessThanSum obj = new DeleteNodesLessThanSum();
		obj.init();
	}

}
