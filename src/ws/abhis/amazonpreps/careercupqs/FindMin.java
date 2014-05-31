package ws.abhis.amazonpreps.careercupqs;

public class FindMin {
	public static int findMin(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if ((arr[i + 1] - arr[i]) > 0) {
				return arr[i];
			}
		}
		return 0;
	}

	public static int findMin2(int arr[]) {
		int l = 0;
		int r = arr.length - 1;
		int result = 0;
		while (l < r) {
			int mid = (l + r) / 2;
			if (arr[l] > arr[mid]) {
				r = mid - 1;
				result = arr[mid];
			} else {
				// mid is greater than l in that case l = mid+1;
				l = mid + 1;
			}

		}

		return result;
	}
	
	//doesnt work
	public static int findMin3(int[] arr, int m) {

		if (m > -1 && m < arr.length) {
			if (arr[m] < arr[m + 1]) {
				findMin3(arr, m / 2);
			} else {
				findMin3(arr, (arr.length - (m + 1)) / 2);
			}
		}

		if (arr[m] > arr[m + 1]) {
			return arr[m + 1];
		}

		return 0;
	}
	
	public static int findMin4(int[] arr) {
		int l = 0;
		int r = arr.length;
		int mid;
		while (l < r) {
			mid = (r-l) / 2;
			if (arr[mid-1] > arr[mid]) {
				return arr[mid];
			} else if (arr[mid] < arr[mid+1]) {
				l = mid+1;
			} else {
				r = mid-1;
			}
		}
		return 0;
	}

	public static void main(String args[]) {
		int[] values = {9,10,1,2,3};
		System.out.println("FindMin: " + findMin4(values));
	}

}
