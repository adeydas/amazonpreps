/*
 * Check if a LL is a palindrome
 */

package ws.abhis.amazonpreps.gayle.linkedlist;

import java.util.Stack;

public class CheckPalindrome {
	public boolean checkPalindrome(MySinglyLinkedList word) {
		//iter till end and put in stack
		Stack<MySinglyLinkedList> stack = new Stack<MySinglyLinkedList>();
		MySinglyLinkedList temp = word;
		while (temp != null) {
			stack.push(temp);
			temp = temp.nextNode;
		}
		
		//iter again and compare with stack
		while (word != null) {
			if (word.value != stack.pop().value) {
				return false;
			}
			word = word.nextNode;
		}
		return true;
	}
	
	public static void main(String[] args) {
		CheckPalindrome obj = new CheckPalindrome();
		MySinglyLinkedList headTrue = new MySinglyLinkedList(1, new MySinglyLinkedList(2, new MySinglyLinkedList(1, null)));
		System.out.println(obj.checkPalindrome(headTrue));
		MySinglyLinkedList headFalse = new MySinglyLinkedList(5, new MySinglyLinkedList(2, new MySinglyLinkedList(1, null)));
		System.out.println(obj.checkPalindrome(headFalse));
	}
}
