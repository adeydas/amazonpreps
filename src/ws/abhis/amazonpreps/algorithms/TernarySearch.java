/*
 * Divide into three parts and search based on that.
 * Array should be sorted.
 */

package ws.abhis.amazonpreps.algorithms;

public class TernarySearch {
	public Integer search(int[] elements, int key, int low, int high) {
		int firstThird = ((high + 1) - low) / 3;
		int secondThird = (2 * ((high + 1) - 1)) / 3;

		if (low > high) {
			// Key won't exist
			return null;
		} else if (key > elements[secondThird]) { // upper third
			return search(elements, key, secondThird + 1, high);
		} else if (key < elements[firstThird]) { // lower third
			return search(elements, key, low, firstThird - 1);
		} else if (key > elements[firstThird]) { // middle third
			return search(elements, key, firstThird + 1, secondThird);
		} else {
			// Found it
			return firstThird;
		}

	}
	
	public static void main(String[] args) {
		int[] elements = {1,2,3,4,5,6};
		TernarySearch obj = new TernarySearch();
		System.out.println(obj.search(elements, 4, 1, 6));
	}
}
