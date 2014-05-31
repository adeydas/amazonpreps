package ws.abhis.amazonpreps.algorithms.trees;

public class RemoveDuplicatesInNTime {
	
	public class LL {
		public int value;
		public LL next;
	}
	
	private LL root;
	private LL next;
	
	public void preprocess(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,1,4,2,1 };
		RemoveDuplicatesInNTime obj = new RemoveDuplicatesInNTime();
		obj.preprocess(arr);
	}
}
