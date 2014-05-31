/*
 * Start in mid for inorder and do recursively.
 */

package ws.abhis.amazonpreps.algorithms;

public class SortedListToBST {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		ListNode cur;

		public TreeNode sortedListToBST(ListNode head) {
			// Start typing your Java solution below
			// DO NOT write main() function
			int length = lengthOfList(head);
			cur = head;
			return BST(0, length - 1);
		}

		TreeNode BST(int start, int end) {
			if (start > end)
				return null;
			int mid = start + (end - start) / 2;
			TreeNode left = BST(start, mid - 1);
			TreeNode parent = new TreeNode(cur.val);
			parent.left = left;
			cur = cur.next;
			parent.right = BST(mid + 1, end);
			return parent;
		}

		int lengthOfList(ListNode head) {
			int counter = 0;
			ListNode current = head;
			while (current != null) {
				counter++;
				current = current.next;
			}
			return counter;
		}
	}
}
