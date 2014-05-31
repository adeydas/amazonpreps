package ws.abhis.amazonpreps.algorithms;

public class MergeSort3 {
	
	private int[] arr;
	
	
	public int sort(int[] arr) {
		this.arr = arr;
		int low = 0;
		int high = arr.length - 1;
		int invCount = mergesort(low, high);
		return invCount;
	}
	
	private int mergesort(int low, int high) {
		int invCount = 0;
		if (low < high-1) {
			int mid = (low + high) / 2;
			
			invCount += mergesort(low, mid);
			invCount += mergesort(mid+1, high);
			invCount += merge(low, mid, high);
		}
		return invCount;
	}
	
	private int merge(int low, int mid, int high) {
		
		int[] tmp = new int[high-low];
		int fromLeft = low;
		int fromMid = mid;
		int invCount = 0;
		
		for (int k=0; k<tmp.length; k++) {
			if (fromMid >= high || (fromLeft<mid && arr[fromLeft] <= arr[fromMid])) {
				tmp[k] = arr[fromLeft];
				fromLeft++;
			} else {
				System.out.println("Inversion pair: " + arr[fromLeft] + ", " + arr[fromMid]);
				tmp[k] = arr[fromMid];
				fromMid++;
				invCount++;
			}
		}
		
		for (int k=low; k<high; k++) {
			arr[k] = tmp[k-low];
		}
		return invCount;
	}
	
	
	public static void main(String[] args) {
		int[] inputArr = { 2, 4, 1, 3, 5  };
		MergeSort3 obj = new MergeSort3();
		int invCount = obj.sort(inputArr);
		for (int i=0; i<inputArr.length; i++) {
			System.out.println(inputArr[i]);
		}
		System.out.println("Inv Count " + invCount);
	}
}
