/*
 * I/P: 7 -> 1 -> 6 and 5 -> 9 -> 2 , which is 617 + 295 = 912 rep as 2 -> 1 -> 9
 */

package ws.abhis.amazonpreps.gayle.linkedlist;

public class AddNumbers {
	
	//If the numbers are not of the same length, pad it with 0's
	
	private int getLength(MySinglyLinkedList head) {
		int counter = 0;
		MySinglyLinkedList temp = head;
		while (temp != null) {
			counter++;
			temp = temp.nextNode;
		}
		return counter;
	}
	
	private MySinglyLinkedList pad(MySinglyLinkedList head, int diff) {
		MySinglyLinkedList a = null;
		for (int i=0; i<diff; i++) {
			if (a==null) {
				a = new MySinglyLinkedList(0, null);
			} else {
				a.nextNode = new MySinglyLinkedList(0, null);
				a = a.nextNode;
			}
		}
		a.nextNode = head;
		return a;
	}
	
	private void preProcess(MySinglyLinkedList one, MySinglyLinkedList two) {
		int oneCounter = getLength(one);
		int twoCounter = getLength(two);
		if (oneCounter > twoCounter) {
			one = pad(one, oneCounter-twoCounter);
		} else if (twoCounter > oneCounter) {
			two = pad(two, twoCounter-oneCounter);
		}
	}
	
	public MySinglyLinkedList sumReverse(MySinglyLinkedList one, MySinglyLinkedList two) {
		MySinglyLinkedList ret = null;
		MySinglyLinkedList retStart = null;
		int carry = 0;
		preProcess(one, two);
		while (one != null && two != null) {
			
			if (ret == null) {
				int sum = one.value + two.value + carry;
				carry = -1;
				if (sum > 9) {
					//there is a carry
					carry = sum/10;
					sum = sum%10;
				}
				ret = new MySinglyLinkedList(sum, null);
				retStart = ret;
			} else {
				int sum = one.value + two.value + carry;
				carry = -1;
				if (sum > 9) {
					carry = sum/10;
					sum = sum % 10;
				}
				ret.nextNode = new MySinglyLinkedList(sum, null);
				ret = ret.nextNode;
			}
			one = one.nextNode;
			two = two.nextNode;
		}
		if (carry != -1) {
			//there is an extra carry
			ret.nextNode = new MySinglyLinkedList(carry, null);
			ret = ret.nextNode;
		}
		return retStart;
	}
	
	public static void main(String[] args) {
		AddNumbers obj = new AddNumbers();
		MySinglyLinkedList one = new MySinglyLinkedList(7, new MySinglyLinkedList(1, new MySinglyLinkedList(6, null)));
		MySinglyLinkedList two = new MySinglyLinkedList(5, new MySinglyLinkedList(9, new MySinglyLinkedList(3, null)));
		MySinglyLinkedList ret =  obj.sumReverse(one, two);
		while(ret != null) {
			System.out.println(ret.value);
			ret = ret.nextNode;
		}
	}
}
