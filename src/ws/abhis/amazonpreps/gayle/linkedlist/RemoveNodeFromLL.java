/*
 * Remove a given node from a singly LL
 */

package ws.abhis.amazonpreps.gayle.linkedlist;

public class RemoveNodeFromLL {
	public MySinglyLinkedList removeNode(MySinglyLinkedList head,
			MySinglyLinkedList removeThisNode) {
		MySinglyLinkedList start = head;
		while (head != null) {
			if (head.nextNode == removeThisNode) {
				head.nextNode = head.nextNode.nextNode;
			}
			head = head.nextNode;
		}
		return start;
	}

	public static void main(String[] args) {
		MySinglyLinkedList removeNode = new MySinglyLinkedList(3, new MySinglyLinkedList(4, null));
		MySinglyLinkedList head = new MySinglyLinkedList(1,
				new MySinglyLinkedList(2,removeNode));
		RemoveNodeFromLL obj = new RemoveNodeFromLL();
		MySinglyLinkedList ret = obj.removeNode(head, removeNode);
		while (ret != null) {
			System.out.println(ret.value);
			ret = ret.nextNode;
		}
	}
}
