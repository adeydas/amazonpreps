/*
 * Given an in-order traversal of a special binary tree having property that the node is 
 * always greater than its left and right child. 
 * 
 * Construct the tree with minimal complexity.
 * 
 * {5,10,8,20,6,7,4}
 */

package ws.abhis.amazonpreps.careercupqs;

public class SpecialBinaryTree {
	public void solution(int[] inOrder) {
		
	}
	
	private int findGlobalMax(int[] arr) {
		int globalMax = Integer.MIN_VALUE;
		for (int i=0; i<arr.length; i++) {
			if (arr[i] > globalMax) {
				globalMax = arr[i];
			}
		}
		return globalMax;
	}
}
