/*
 * Given a binary tree, 
 * write a function to get the maximum width of the given tree. Width of a tree is maximum of widths of all levels.
 */

package ws.abhis.amazonpreps.algorithms.trees;

import ws.abhis.amazonpreps.algorithms.trees.DepthOfATree.Node;

public class MaximumWidthOfBinaryTree {
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
	
	public int getMaxWidth (Node node) {
		int maxWidth = 0;
		int width = 0;
		int h = height(node);
		
		for (int i=0; i<h; i++) {
			//traverse through all levels
			width = getWidth(node, i);
			if (width > maxWidth) {
				maxWidth = width;
			}
		}
		
		return maxWidth;
	}

	private int getWidth(Node node, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int height(Node node) {
		// TODO Auto-generated method stub
		return 0;
	}
}
