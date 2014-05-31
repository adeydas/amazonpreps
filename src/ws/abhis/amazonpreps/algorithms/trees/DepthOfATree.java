/*
 * Find depth or height of a tree.
 */

package ws.abhis.amazonpreps.algorithms.trees;


public class DepthOfATree {
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
	
	public int solution(Node node) {
		if (node == null) {
			return 0;
		}
		
		int lDepth = solution(node.left);
		int rDepth = solution(node.right);
		
		if (lDepth > rDepth) {
			return lDepth + 1; //+1 for root
		} else {
			return rDepth + 1;
		}
	}
	
	public void init() {
		Node one = new Node (1, new Node(2, new Node(3, null, null), null), null);
		System.out.println(solution(one));
	}
	
	public static void main(String[] args) {
		DepthOfATree obj = new DepthOfATree();
		obj.init();
	}
}
