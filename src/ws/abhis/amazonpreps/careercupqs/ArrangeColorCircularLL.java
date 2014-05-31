/*
 * Given a circular linked list with each node either r,g,y or b. number of nodes of each color are same. 
 * Arrange the nodes in a specified order. Eg. if list is like "rrrgggyyybbb" and order is "rgyb" then after rearrangement it should 
 * be "rgybrgybrgybrgyb". Just a bit more explanation...the question was given in form of students stading in a circular fashion and 
 * color denotes the club they are in. Hence adding new node or list is not possible.
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.List;

public class ArrangeColorCircularLL {

	public class Queue {
		List<Character> q = new ArrayList<Character>();

		public void push(char c) {
			q.add(c);
		}

		public char pop() {
			char v = q.get(0);
			q.remove(0);
			return v;
		}

		public int getQueueSize() {
			return q.size();
		}
	}

	public class CircularLinkedListNode {
		private char v;
		private CircularLinkedListNode next;

		public char getV() {
			return v;
		}

		public void setV(char v) {
			this.v = v;
		}

		public CircularLinkedListNode getNext() {
			return next;
		}

		public void setNext(CircularLinkedListNode next) {
			this.next = next;
		}
	}

	private Queue colorR = new Queue();
	private Queue colorG = new Queue();
	private Queue colorY = new Queue();
	private Queue colorB = new Queue();

	public void arrangeColors(CircularLinkedListNode seq, char[] pattern) {
		// Iterate through the linked list and put in respective buckets
		// this solution doesn't detect cycles. use flyod cycle algorithm for
		// that
		CircularLinkedListNode firstNode = seq;
		CircularLinkedListNode tempNode = seq.getNext();
		while (tempNode != firstNode) {
			if (tempNode.getV() == 'r') {
				colorR.push('r');
			} else if (tempNode.getV() == 'g') {
				colorG.push('g');
			} else if (tempNode.getV() == 'y') {
				colorY.push('y');
			} else {
				colorB.push('b');
			}
			tempNode = tempNode.getNext();
		}

		while (colorR.getQueueSize() > 0 || colorG.getQueueSize() > 0
				|| colorY.getQueueSize() > 0 || colorB.getQueueSize() > 0) {

			for (int i = 0; i < pattern.length; i++) {
				char t = pattern[i];
				if (t == 'r' && colorR.getQueueSize() > 0) {
					System.out.println(colorR.pop());
				} else if (t == 'g' && colorG.getQueueSize() > 0) {
					System.out.println(colorG.pop());
				} else if (t == 'y' && colorY.getQueueSize() > 0) {
					System.out.println(colorY.pop());
				} else if (t == 'b' && colorB.getQueueSize() > 0) {
					System.out.println(colorB.pop());
				}
			}
		}
	}
	
	
	
}
