/*
 * Given a binary tree and a number, return true if the tree has a root-to-leaf path such that adding up all the 
 * values along the path equals the given number. 
 * Return false if no such path can be found.
 */

package ws.abhis.amazonpreps.algorithms.trees;

public class CheckIfPathWithSumExists {
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

	public boolean solution(Node tree, int value) {
		if (tree.left == null && tree.right == null && tree.value - value == 0) {
			return true;
		}

		if (tree.left != null) {
			solution(tree.left, tree.value - value);
		}
		if (tree.right != null) {
			solution(tree.right, tree.value - value);
		}

		return false;
	}

	public void init() {
		Node one = new Node(1, new Node(2, new Node(3, null, null), null), null);
		System.out.println(solution(one, 6));
	}

	public static void main(String[] args) {
		CheckIfPathWithSumExists obj = new CheckIfPathWithSumExists();
		obj.init();
	}
}
