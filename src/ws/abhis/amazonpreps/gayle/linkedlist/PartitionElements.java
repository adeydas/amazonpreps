/*Partition elements such that all nodes less than x comes before x and greater than or equal after */

package ws.abhis.amazonpreps.gayle.linkedlist;

public class PartitionElements {

	// have stable sort
	public MySinglyLinkedList partitionElements(MySinglyLinkedList head,
			MySinglyLinkedList ele) {
		MySinglyLinkedList less = null;
		MySinglyLinkedList more = null;
		MySinglyLinkedList start = null;
		MySinglyLinkedList startMore = null;

		while (head != null) {
			if (head.value < ele.value) {
				if (less == null) {
					less = head;
					start = less;
				} else {
					less.nextNode = head;
					less = less.nextNode;
				}
			} else {
				if (more == null) {
					more = head;
					startMore = more;
				} else {
					more.nextNode = head;
					more = more.nextNode;
				}
			}
			head = head.nextNode;
		}
		less.nextNode = startMore;
		return start;
	}

	public static void main(String[] args) {
		MySinglyLinkedList ele = new MySinglyLinkedList(3, null);
		MySinglyLinkedList head = new MySinglyLinkedList(5,
				new MySinglyLinkedList(1, new MySinglyLinkedList(2,
						new MySinglyLinkedList(3, null))));
		PartitionElements obj = new PartitionElements();
		MySinglyLinkedList ret = obj.partitionElements(head, ele);
		while (ret != null) {
			System.out.println(ret.value);
			ret = ret.nextNode;
		}
	}
}
