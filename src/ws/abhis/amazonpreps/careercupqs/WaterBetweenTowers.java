/*
 * You are given an array whose each element represents the height of the tower. The width of every tower is 1. 
 * It starts raining. How much water is collected between the towers? 
Eg. [1,5,3,7,2] – then answer is 2 units between towers 5 and 7.
 */

package ws.abhis.amazonpreps.careercupqs;

public class WaterBetweenTowers {

	public Integer solution(int selectIndex, int[] arr) {
		int globalLValue = arr[selectIndex];
		int globalRValue = arr[selectIndex];
		int globalLIndex = 0;
		int globalRIndex = 0;

		// check the left side for a taller tower
		for (int i = 0; i < selectIndex; i++) {
			if (arr[i] > globalLValue) {
				globalLValue = arr[i];
				globalLIndex = i;
			}
		}
		// check the left side for a taller tower
		for (int i = selectIndex + 1; i < arr.length; i++) {
			if (arr[i] > globalRValue) {
				globalRValue = arr[i];
				globalRIndex = i;
			}
		}

		/*
		 * There can be two cases: 1. both LValue and RValue present 2. Either
		 * LValue or RValue present
		 */

		if (globalLValue > arr[selectIndex] && globalRValue == arr[selectIndex]) {
			int diff = globalLValue - arr[selectIndex];
			int index = selectIndex - globalLIndex;
			return diff * index;
		} else if (globalLValue == arr[selectIndex]
				&& globalRValue > arr[selectIndex]) {
			int diff = globalRValue - arr[selectIndex];
			int index = globalRIndex - selectIndex;
			return diff * index;
		} else {
			if (globalLValue > globalRValue) {
				int diff = globalLValue - globalRValue;
				int index = globalRIndex - globalLIndex;
				return diff * index;
			} else {
				int diff = globalRValue - globalLValue;
				int index = globalRIndex - globalLIndex;
				return diff * index;
			}
		}

	}
	

	
	
}
