/*
 * Given a read only linked list with next and random pointer , clone the list.
 */

package ws.abhis.amazonpreps.careercupqs;

public class CloneListWithRandomPointer {
	public class LinkedList {
		public int value;
		public LinkedList nextPointer;
		public LinkedList randomPointer;
		
		public LinkedList(int value, LinkedList nextPointer, LinkedList randomPointer) {
			this.value = value;
			this.nextPointer = nextPointer;
			this.randomPointer = randomPointer;
		}
		
		public LinkedList () {}
	}
	
	
	
	public void solution(LinkedList root, LinkedList cloneNode) {
		if (root == null) {
			return;
		}
		if (cloneNode == null) {
			cloneNode = new LinkedList();
			cloneNode = root;
		} else {
			cloneNode.nextPointer = new LinkedList();
			cloneNode.nextPointer = root;
		}
		
		solution(root.nextPointer, cloneNode);
	}
	
	public void init() {
		LinkedList one = new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, null, null), null), null), null);
		LinkedList clone = null;
		solution(one, clone);
		while (clone != null) {
			System.out.println(clone.value);
			clone = clone.nextPointer;
		}
	}
	
	
	public static void main(String[] args) {
		CloneListWithRandomPointer obj = new CloneListWithRandomPointer();
		obj.init();
	}
	
}
