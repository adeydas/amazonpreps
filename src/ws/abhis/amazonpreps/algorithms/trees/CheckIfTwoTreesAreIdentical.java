/*
 * Check if two trees are identical
 */

package ws.abhis.amazonpreps.algorithms.trees;

public class CheckIfTwoTreesAreIdentical {
	public class Node {
		public int value;
		public Node left;
		public Node right;
	}

	public boolean solution(Node tree1, Node tree2) {
		if (tree1 == null && tree2 == null) {
			return false;
		}

		return (tree1.value == tree2.value)
				&& (solution(tree1.left, tree2.left))
				&& (solution(tree2.left, tree2.right));
	}
	
	
}
