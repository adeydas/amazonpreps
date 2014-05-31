/*
 * Find the largest sequence in a array which sums to zero.
 * --continuous seq, find the N value
 */

package ws.abhis.amazonpreps.careercupqs;

public class LargestSeqSumToZero {
	public int solution(int[] elements) {
		int length = elements.length;
		//check if array contains only one elements
		if (length == 1) {
			return length;
		}
		//check if array contains no elements
		if (elements == null || length == 0) {
			return length;
		}
		
		
		int localSum = 0;
		int globalN = 0;
		int localN = 0;
		for (int i=0; i<length; i++) {
			localSum += elements[i];
			localN = i;
			if (localSum == 0) {
				if (localN > globalN) {
					globalN = localN;
					localN = 0;
					localSum = 0;
				}
			} 
		}
		return globalN;
	}
	
	public static void main(String[] args) {
		LargestSeqSumToZero obj = new LargestSeqSumToZero();
		int[] elements = {5,-2,-3,1,2};
		int result = obj.solution(elements);
		System.out.println(result);
	}
}
