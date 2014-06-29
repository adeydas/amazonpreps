/*
 * LL 1 -> 2 -> 3 -> 4 -> 2, print the beginning of the loop, O/P - 2
 */

package ws.abhis.amazonpreps.gayle.linkedlist;

public class CorruptLL {
	public void findCorrupt(MySinglyLinkedList head) {
		MySinglyLinkedList tortoise = head;
		MySinglyLinkedList hare = head.nextNode;
		while (tortoise != hare) {
			tortoise = tortoise.nextNode;
			hare = hare.nextNode;
		}
		System.out.println(tortoise.value);
	}
	
	public static void main(String[] args) {
		CorruptLL obj = new CorruptLL();
		MySinglyLinkedList two = new MySinglyLinkedList(2, new MySinglyLinkedList(3, null));
		two.nextNode = two;
		MySinglyLinkedList head = new MySinglyLinkedList(1, two);
		obj.findCorrupt(head);
	}
}
