/*
 * Check whether a tree can be folded in the middle
 * 					   2
 * 				10			10
 * 			12		14	  14	12
 */
package ws.abhis.amazonpreps.careercupqs;

public class WhetherTreeFolded {
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

	public void init() {
		Node one = new Node(2, new Node(10, new Node(12, null, null), new Node(14, null, null)), new Node(10, new Node(14, null, null), new Node(12, null, null)));
		System.out.println(checkWhetherTreeCanBeFolded(one));
	}

	public boolean checkWhetherTreeCanBeFolded(Node root) {
		boolean b = checkFolded(root.left, root.right);
		return b;
	}

	private boolean flag = true;

	private boolean checkFolded(Node tree1, Node tree2) {
		if (tree1.value != tree2.value) {
			return false;
		}
		if (tree1.left != null && tree2.right != null) {
			flag = checkFolded(tree1.left, tree2.right);
		}
		if (tree1.right != null && tree2.left != null) {
			flag = checkFolded(tree1.right, tree2.left);
		}
		
		return flag;
	}
	
	public static void main(String[] args) {
		WhetherTreeFolded obj = new WhetherTreeFolded();
		obj.init();
	}

}
